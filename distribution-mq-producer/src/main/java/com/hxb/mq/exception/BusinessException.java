package com.hxb.mq.exception;

import lombok.Data;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-25 16:12:38
 */
@Data
public class BusinessException extends RuntimeException {

    static final String DEFAULT_MESSAGE = "操作失败";

    private Object data;
    private String msg;

    public BusinessException(String msg,Object data) {
        this.msg = msg;
        this.data = data;
    }

    public BusinessException(String msg) {
        this(msg,null);
    }

    public BusinessException(Object data){
        this(DEFAULT_MESSAGE,data);
    }
}
