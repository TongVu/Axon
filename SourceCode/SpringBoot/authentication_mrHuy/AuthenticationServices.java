package com.axonactive.iot.sniffermind.authentication;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.axonactive.exception.UnauthorizedAccessException;
import com.axonactive.iot.sniffermind.resourcebundle.ApplicationConfigResourceServices;
import com.axonactive.iot.sniffermind.resourcebundle.MessageServices;
import com.axonactive.iot.sniffermind.resourcebundle.MessageServices.ErrorCode;
import com.axonactive.iot.sniffermind.user.User;

@Stateless
public class AuthenticationServices {
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationServices.class);

	@EJB
	private MessageServices messageService;

	@EJB
	private ApplicationConfigResourceServices appConfigService;

	private User checkValidUser(User user) {
		User dummyUser = appConfigService.getDummyUser();
		String dummyUserUsername = dummyUser.getUsername();
		String dummyUserPasswordMD5 = String.valueOf(dummyUser.getPassword());
		
		String passwordMD5 = String.valueOf(user.getPassword());

		if (!(dummyUserUsername.equalsIgnoreCase(user.getUsername()) 
				&& dummyUserPasswordMD5.equalsIgnoreCase(passwordMD5))) {
			throw new UnauthorizedAccessException(ErrorCode.INVALID_INPUT_REQUEST,
					messageService.get(ErrorCode.INVALID_INPUT_REQUEST));
		}
		return user;
	}

	public Token createToken(User user) {
		this.checkValidUser(user);

		String token = null;
		String secretKey = appConfigService.getSecretKey();
		String issuer = appConfigService.getJWTIssuer();
		int timeToLive = appConfigService.getTimeToLive();

		try {
			Algorithm algorithm = Algorithm.HMAC512(secretKey);
			token = JWT.create()
					.withIssuer(issuer)
					.withClaim("username", user.getUsername())
					.withExpiresAt(this.setTokenTimeToLive(timeToLive))
					.sign(algorithm);
		} catch (IllegalArgumentException e) {
			logger.info(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.info(e.getMessage());
		}
		if (token == null) {
			throw new UnauthorizedAccessException(ErrorCode.INVALID_INPUT_REQUEST,
					messageService.get(ErrorCode.INVALID_INPUT_REQUEST));
		}
		return new Token(token, timeToLive);
	}

	public void checkAuthorizedToken(String token) {
		if (token == null) {
			throw new UnauthorizedAccessException(ErrorCode.INVALID_INPUT_REQUEST,
					messageService.get(ErrorCode.INVALID_INPUT_REQUEST));
		}
		try {
			String secretKey = appConfigService.getSecretKey();
			Algorithm algorithm = Algorithm.HMAC512(secretKey);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
		} catch (JWTVerificationException e) {
			logger.info(e.getMessage());
			throw new UnauthorizedAccessException(ErrorCode.INVALID_INPUT_REQUEST,
					messageService.get(ErrorCode.INVALID_INPUT_REQUEST));
		} catch (IllegalArgumentException | UnsupportedEncodingException e) {
			logger.info(e.getMessage());
		} 
	}

	private Date setTokenTimeToLive(int minutes) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}

}
