package com.preference.userprofile.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;

/**
 * This is a HttpRequest Interceptor class for logging the incoming request and response time.
 * @author Mohamed Rafeek
 */

@Component
public class CustomRequestLoggingInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomRequestLoggingInterceptor.class);

    /**
     * Log request details before making the http call.
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Instant startTime = Instant.now();
        LOGGER.info("Received HTTP request::{}, :: Start Time={}", request.getRequestURL(), startTime);
        request.setAttribute("startTime", startTime.toEpochMilli());
        return true;
    }

    /**
     * Log request & response after http call is finished.
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LOGGER.info("Processed HTTP request::{}, :: Time Taken={}ms  Status:: {}", request.getRequestURL(),
                (Instant.now().toEpochMilli() - (Long) request.getAttribute("startTime")), response.getStatus());
    }
}
