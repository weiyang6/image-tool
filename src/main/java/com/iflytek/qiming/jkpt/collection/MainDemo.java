package com.iflytek.qiming.jkpt.collection;


/**
 * @ClassName MainDemo
 * @Description TODO
 * @Author weiyang
 * @Date 2019/10/23 22:26
 * @Version 1.0
 **/
public class MainDemo {
   public static void main(String[] args){
      int k=3;
      int num=4;
      int[] n=new int[]{3,11,6,9};
      int tmp=0;
      int h=8;
      while (true){
         tmp=0;
         for(int i=0;i<num;i++){
            if(n[i]%k==0){
               tmp+=n[i]/k;
            }else{
               tmp+=n[i]/k+1;
            }
         }
         if(tmp>h){
            k+=1;
            continue;
         }else {
            break;
         }
      }

      System.out.println(k);
   }
}
