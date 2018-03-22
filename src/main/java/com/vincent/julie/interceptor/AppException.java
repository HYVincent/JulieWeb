package com.vincent.julie.interceptor;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator QQ:1032006226
 * @version v1.0
 * @name JulieWeb
 * @page com.vincent.julie.interceptor
 * @class describe
 * @date 2018/3/22 20:53
 */

public class AppException implements HandlerExceptionResolver{


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }
}
