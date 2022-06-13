package com.axonactive.companyspringrun2.Service.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.axonactive.companyspringrun2.exception.UnauthorizedAccessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
@Slf4j
@Service
public class    JwtAuthenticationService {

    private User checkValidUser(User user) throws UnauthorizedAccessException {
        if (!("nhancute".equalsIgnoreCase(user.getUserName())
                && user.getPassWord().equals("12345678"))) {
            throw new UnauthorizedAccessException("Unauthorized user");
        }
        return user;
    }

    public Token createToken(User user) throws UnauthorizedAccessException {
        this.checkValidUser(user);

        String token = null;
        String secretKey = "alibaba";
        String issuer ="40tencuop";
        int timeToLive = 690_000_000;

        try {
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            token = JWT.create()
                    .withIssuer(issuer)
                    .withClaim("username", user.getUserName())
                    .withExpiresAt(this.setTokenTimeToLive(timeToLive))
                    .sign(algorithm);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
        if (token == null) {
            throw new UnauthorizedAccessException("Unauthorized");
        }
        return new Token(token, timeToLive);
    }

    public void checkAuthorizedToken(String token) throws UnauthorizedAccessException {
        log.info("Input token is: {}", token);
        if (token == null) {
            throw new UnauthorizedAccessException("Unauthorized");
        }
        try {
            String secretKey = "alibaba";
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            log.info(e.getMessage());
            throw new UnauthorizedAccessException("Unauthorized");
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }

    private Date setTokenTimeToLive(int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }
}
