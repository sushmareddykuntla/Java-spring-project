package com.sushma.filter;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RequestLoggingFilter implements Filter {
	
	    private static final Logger logger =
	            LoggerFactory.getLogger(RequestLoggingFilter.class);

	    @Override
	    public void doFilter(ServletRequest request,
	                         ServletResponse response,
	                         FilterChain chain)
	            throws IOException, ServletException {

	        HttpServletRequest httpRequest = (HttpServletRequest) request;

	        String requestUUID = httpRequest.getHeader("RequestUUID");

	        if (requestUUID == null || requestUUID.isEmpty()) {
	            requestUUID = UUID.randomUUID().toString();
	        }

	        long startTime = System.currentTimeMillis();

	        logger.info("REQUEST START | RequestUUID={} | URI={}",
	                requestUUID,
	                httpRequest.getRequestURI());

	        // Attach RequestUUID to request (available everywhere)
	        httpRequest.setAttribute("RequestUUID", requestUUID);

	        chain.doFilter(request, response);

	        long timeTaken = System.currentTimeMillis() - startTime;

	        logger.info("REQUEST END | RequestUUID={} | TimeTaken={} ms",
	                requestUUID,
	                timeTaken);
	    }
	}

