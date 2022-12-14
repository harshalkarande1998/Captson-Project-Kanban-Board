package com.niit.boards.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String auth = req.getHeader("Authorization");
        if(auth.isEmpty())
            throw new ServletException("The token cannot be found");
        if(!auth.startsWith("Bearer "))
            throw new ServletException("The token is not a bearer token");
        String token = auth.substring(7);
        Claims claims = Jwts.parser().setSigningKey("group2kanbanboard").parseClaimsJws(token).getBody();
        req.setAttribute("claims", claims);
        chain.doFilter(req,res);
    }
}
