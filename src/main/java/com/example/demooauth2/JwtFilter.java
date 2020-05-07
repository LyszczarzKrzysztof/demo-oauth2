package com.example.demooauth2;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.rmi.ServerException;

public class JwtFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");

        // to Bearer ze spacją jest jakimś przedrostkiem do tokenów
        if(httpServletRequest == null || header.startsWith("Bearer ")){
            throw new ServerException("Wring or empty header");
        }else {
            // teraz usuwa teko Bearer ze spacją
           String headerToken = header.substring(7);
           Claims claims = (Claims) Jwts.parser().setSigningKey("password").parseClaimsJws(headerToken).getBody();
        }
    }
}
