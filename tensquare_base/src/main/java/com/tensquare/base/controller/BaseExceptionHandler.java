package com.tensquare.base.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 * date: 2018/11/26 19:18
 * author: loveLy
 */
//@RestControllerAdvice
@ControllerAdvice
public class BaseExceptionHandler {


    @ExceptionHandler
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return new Result(false,StatusCode.ERROR,e.getMessage());
    }
}
