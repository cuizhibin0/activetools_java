package com.pay.activetools.exception;

import com.pay.activetools.bean.JsonResultView;
import com.pay.activetools.enums.CodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description:
 * @Author: zhibin.cui
 * @Date: 下午4:54 2018/6/17
 */
@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResultView unknownException(Exception ex){
        logger.error("异常信息:()",ex);
        return new JsonResultView(CodeEnum.FAIL);
    }

}
