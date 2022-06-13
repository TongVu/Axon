package com.axonactive.companyspringrun2.controllers;

import com.axonactive.companyspringrun2.exception.UnauthorizedAccessException;
import com.axonactive.companyspringrun2.Service.security.JwtAuthenticationService;
import com.axonactive.companyspringrun2.Service.security.Token;
import com.axonactive.companyspringrun2.Service.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping(UserController.PATH)
@RestController
public class UserController {
    public static final String PATH = "/api/user";
@Autowired
    JwtAuthenticationService jwtAuthenticationService;
    @PostMapping
    public Token getAuthenticationToken(@RequestBody User user) throws UnauthorizedAccessException {
        return jwtAuthenticationService.createToken(user);
    }
}
