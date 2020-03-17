package com.iflytek.qiming.jkpt.demo;


import java.util.HashMap;

/**
 * @ClassName HwDemo
 * @Description TODO
 * @Author weiyang
 * @Date 2020/2/25 17:17
 * @Version 1.0
 **/
public class HwDemo {

    public static boolean isLs(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Character> hashMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hashMap.containsKey(s.charAt(i))){
                if(hashMap.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                if(hashMap.containsValue(t.charAt(i))){
                    return false;
                }
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s="foo";
        String t="bar";


        String s1="agg";
        String t1="add";

        System.out.println(isLs(s1,t1));
    }
}
