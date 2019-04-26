package com.hxb.mq.util;

import com.alibaba.fastjson.JSON;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 15:59:53
 */
public class JsonUtil {

    public static String toJsonString(Object obj){
        return JSON.toJSONString(obj);
    }






    private JsonUtil(){}

}