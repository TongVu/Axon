package com.axonactive.iot.sniffermind.authentication;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.axonactive.iot.sniffermind.generic.ResultStatus;
import com.axonactive.iot.sniffermind.sniffer.SnifferResponse;
import com.axonactive.iot.sniffermind.user.User;
import com.axonactive.sniffermind.util.BasicAuthentication;

@Stateless
@Path("auth")
public class AuthenticationResources {

    @EJB
    AuthenticationServices jwtAuthServices;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AuthenticationResponse getAuthenticationToken(@Valid User user) {
    	Token token = jwtAuthServices.createToken(user);
    	return new AuthenticationResponse(token, ResultStatus.buildSuccessResultStatus());
    }
    
}
