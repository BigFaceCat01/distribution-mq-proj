package com.hxb.mq.aop;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 用于模拟lombok编译时动态生成代码
 * @author Created by huang xiao bao
 * @date 2019-04-28 11:43:09
 */
public class LombokDemo extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
