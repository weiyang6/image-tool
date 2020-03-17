package com.iflytek.qiming.jkpt.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> array=new ArrayList<>();
        while (in.hasNextInt()) {
           array.add(in.nextInt());
        }
        if(array.size()==0){
            System.out.println(-1);
        }
        int len=array.size();
        int h=array.get(len-1);
        if(h<len-1){
            System.out.println(-1);
            return;
        }
        int sum=0;
        for(int i=0;i<len-1;i++){
           sum+=array.get(i);
        }
        if(sum<=0||sum>=Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        int k=sum/h;
        if(sum%h!=0){
            k+=1;
        }
        while (true){
            int tmp=0;
            for(int i=0;i<len-1;i++){
                int num=array.get(i);
                if(num%k==0){
                    tmp+=num/k;
                }else{
                    tmp+=num/k+1;
                }
            }
            if(tmp>h){
                k+=1;
                continue;
            }else {
                System.out.println(k);
                return;
            }

        }
    }
}
