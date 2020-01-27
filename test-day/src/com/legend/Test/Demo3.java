package com.legend.Test;

/**
 * @author Create By legend
 * @date 2019/3/22 18:52
 * 3.输入一个正数n，输出所有和为n的连续正数序列。
 */
public class Demo3 {
    public static void main(String[] args){
        find(15);

    }

    public static void find(int n){
        int min = 1;
        int max = 1;
        int sum = 1;
        while (max<=n/2+1){
            if (sum == n){
                for (int i = min; i <= max; i++) {
                    System.out.print(i+" ");
                }
                System.out.println("");
                sum-=min;
                max++;
                min++;
                sum+=max;
            }

            if (sum>n){
                sum-=min;
                min++;
            }else {
                max++;
                sum+=max;
            }
        }
    }
}
