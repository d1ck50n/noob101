package com.springboot.authentication;

import com.springboot.store.user.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author dicksonk
 */
public class RestAuthorizationFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(RestAuthorizationFilter.class);

    private final UserService userService;

    public RestAuthorizationFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(FilterConfig fc) throws ServletException {
        // INIT
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authHeader = httpRequest.getHeader("Authorization");
        SecurityContextHolder.clearContext();
        if (authHeader != null) {
            log.debug("Getting header of Authorization: {} ", authHeader);
            String authenticationToken = getAuthToken(authHeader);
            Authentication authentication = new UserAuthentication(userService.getUserByToken(authenticationToken));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
        // SecurityContextHolder.clearContext();        
        // SecurityContextHolder.getContext().setAuthentication(null);

    }

    private String getAuthToken(String authHeader) {
        return authHeader.substring(6, authHeader.length());
    }

    @Override
    public void destroy() {
        //DESTROY
    }
}
