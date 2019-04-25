package com.hxb.mq.exception;

import com.hxb.structure.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 异常捕获处理
 * @author update by huang xiao bao
 * @date 2019-04-25 16:11
 */
@RestControllerAdvice
@Slf4j
@Component
public class GlobalExceptionHandler {
    /**
     * 业务异常
     * @param exception 异常
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handle(BusinessException exception) {
        log.error(exception.getMsg()+":{}", Objects.nonNull(exception.getData()) ? exception.getData() : "");
        return Result.build("-1",BusinessException.DEFAULT_MESSAGE,exception.getData());
    }
    /**
     * 未知异常
     * @param exception 异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Object handle(Exception exception) {
        log.error(BusinessException.DEFAULT_MESSAGE, exception);
        return Result.build("-1",BusinessException.DEFAULT_MESSAGE);
    }

}