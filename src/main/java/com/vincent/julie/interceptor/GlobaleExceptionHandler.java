package com.vincent.julie.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator QQ:1032006226
 * @version v1.0
 * @name JulieWeb
 * @page com.vincent.julie.interceptor
 * @class describe
 * @date 2018/3/22 21:08
 */

@ControllerAdvice
public class GlobaleExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map<String, Object> handlerException(Exception e) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("errorMsg", e.getMessage());
        return resultMap;
    }
}
