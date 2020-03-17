package com.iflytek.qiming.jkpt.sort;

import java.util.Arrays;

/**
 * @ClassName SortDemo
 * @Description 排序练习
 * @Author weiyang
 * @Date 2019/11/11 22:42
 * @Version 1.0
 **/
public class SortDemo {
    /**
     * @Author weiyang
     * @Description 直接插入排序
     * @Date  2019/11/11 22:43
     * @Param
     * @return void
    **/
    public static void insertSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
             for(int j=i+1;j>0;j--){
                 if(arr[j]>arr[j-1]){
                     break;
                 }
                 //交换
                 int tmp=arr[j-1];
                 arr[j-1]=arr[j];
                 arr[j]=tmp;
             }
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{3,6,9,1,7};
        insertSort(arr);
        Arrays.stream(arr).forEach(o-> System.out.println(o));
    }



}
