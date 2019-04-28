package com.hxb.common.model.response;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Objects;

/**
 * @author Created by huang xiao bao
 * @date 2019-04-26 09:43:47
 */
@Data
public class CacheResult {

    private Boolean success;
    private Object data;

    private CacheResult(){}

    public CacheResult(Boolean success,Object data) {
        this.success = success;
        this.data = data;
    }

    public static CacheResult build(boolean success,@Nullable Object data){
        return new CacheResult(success,data);
    }

    public static CacheResult success(@Nullable Object data){
        return build(true,data);
    }

    public static CacheResult success(){
        return build(true,null);
    }

    public static CacheResult fail(){
        return build(false,null);
    }

    @SuppressWarnings(value = "unchecked")
    public <T> T getData(Class<T> tClass){
        return Objects.nonNull(data) ? (T)data : null;
    }
}
