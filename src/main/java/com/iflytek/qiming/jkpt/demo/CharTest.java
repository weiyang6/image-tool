package com.iflytek.qiming.jkpt.demo;

import java.util.Stack;

/**
 * @ClassName CharTest
 * @Description TODO
 * @Author weiyang
 * @Date 2020/2/25 15:12
 * @Version 1.0
 **/
public class CharTest {

    public static void main(String[] args) {

      String[] strs=new String[]{"{",")","}"};
      System.out.println(method(strs));
    }

    public static  boolean method(String[] strs){
        Stack<String> stack=new Stack<>();
         boolean flag=false;
        for (String str: strs) {
            if(str.equals("{")||str.equals("(")||str.equals("[")){
                stack.push(str);
            }else{
                if(isSys(stack.peek(),str)){
                    stack.pop();
                }else {
                    return false;
                }
            }

        }
        if(stack.isEmpty()){
            flag=true;
        }
        return flag;
    }

    public static  boolean isSys(String begin,String end){
        if (begin.equals("{") && end.equals("}") ||
                begin.equals("[") && end.equals("]") ||
                begin.equals("(") && end.equals(")")
        ) {

            return true;
        }
        return false;
    }

}
