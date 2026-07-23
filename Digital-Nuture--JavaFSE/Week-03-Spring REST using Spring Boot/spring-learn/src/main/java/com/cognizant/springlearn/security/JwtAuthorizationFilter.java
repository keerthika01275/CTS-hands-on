package com.cognizant.springlearn.security;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("START - JwtAuthorizationFilter Constructor");
        LOGGER.debug("{}: ", authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        LOGGER.info("START - doFilterInternal");
        
        String header = req.getHeader("Authorization");
        LOGGER.debug("Authorization Header: {}", header);
        
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            LOGGER.info("END - doFilterInternal (No valid Bearer token found)");
            return;
        }
        
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
        
        LOGGER.info("END - doFilterInternal");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            Jws<Claims> jws;
            try {
                // Remove Bearer prefix and validate the token signature
                jws = Jwts.parser()
                        .setSigningKey("secretkey")
                        .parseClaimsJws(token.replace("Bearer ", ""));
                        
                String user = jws.getBody().getSubject();
                LOGGER.debug("Decoded JWT User: {}", user);
                
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                LOGGER.error("JWT Authentication failed: {}", ex.getMessage());
                return null;
            }
        }
        return null;
    }
}
