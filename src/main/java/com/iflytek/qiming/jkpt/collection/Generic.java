package com.iflytek.qiming.jkpt.collection;

import sun.rmi.runtime.Log;

/**
 * @ClassName Generic
 * @Description TODO
 * @Author weiyang
 * @Date 2019/10/23 22:23
 * @Version 1.0
 **/
public class Generic<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }

    public void showKeyValue1(Generic<Number> obj){
        System.out.println("泛型测试:key value is " + obj.getKey());
    }


}


