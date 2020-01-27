package com.legend.Test;

/**
 * @author Create By legend
 * @date 2019/3/22 16:35
 *
 * 二分查找(已经是排好序的)
 */
public class BinarySearch {
    public static void main(String[] args){
        int[]A = {12,3,44,5,1,13,7,4,3,0,2};
        int n = A.length;
        sort(A);
        int val = 3;
        int pos = getPos(A, n, val);
        System.out.println("第一次出现的位置"+pos);
    }

    //获取位置
    public static int getPos(int[]A,int n,int val){
        int low = 0;
        int high = n-1;
        int mid;
        while (low<= high){
            mid = (low+high)/2;
            if (A[mid] == val){
                for (int i = mid; i >=0; i--) {
                    if (A[mid] ==A[i]){
                        mid = i;
                        continue;
                    }else {
                        break;
                    }
                }
                return mid;
            }

            if (A[mid]>val){
                high = mid-1;
            }else {
                low = mid+1;

            }
        }
        return -1;
    }

    //排序
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
