package com.example.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    final String format = "LoginSuccessHandler => {}";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        HttpSession httpSession = request.getSession();

        log.info(format, httpSession.getAttribute("url"));

        String role = authentication.getAuthorities().toArray()[0].toString();

        log.info(format, role);

        if(role.equals("ROLE_USER")) {
            response.sendRedirect(request.getContextPath() + (String)httpSession.getAttribute("url"));
        }

    }

    
}
