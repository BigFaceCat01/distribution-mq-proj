package com.hxb.mq.service.impl;

/**
 * @author Created by huang xiao bao
 * @date 2019-05-21 16:23:37
 */
public class TempService {
    public void say(String hello){
        System.out.println(hello);
        walk();
    }
    public void walk(){
        System.out.println("walk");
    }
}
