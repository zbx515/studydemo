package com.example.demo.spboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExecption {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String testExecption(Exception e){
        return "统一异常处理"+e.getMessage();
    }
}
