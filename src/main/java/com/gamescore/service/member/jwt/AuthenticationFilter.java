package com.gamescore.service.member.jwt;


import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {
    private Token token;

    public AuthenticationFilter(Token token) {
        this.token = token;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, JWTVerificationException {
        String tokenStr = request.getHeader("auth");
        token.verify(tokenStr);
    }
}
