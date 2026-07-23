package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("START - authenticate");
        LOGGER.debug("Auth Header: {}", authHeader);
        
        String user = getUser(authHeader);
        LOGGER.debug("Extracted User: {}", user);
        
        String token = generateJwt(user);
        
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        
        LOGGER.info("END - authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        // Strip the "Basic " prefix
        String encodedCredentials = authHeader.replace("Basic ", "");
        
        // Decode the Base64 username:password string
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes);
        
        // Split by colon and return just the username
        String user = decodedString.split(":")[0];
        return user;
    }

    private String generateJwt(String user) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());

        // Set the token expiry as 20 minutes from now (1200000 ms)
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        
        // Sign the token using the secret key
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        return builder.compact();
    }
}
