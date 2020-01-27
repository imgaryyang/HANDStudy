package com.legend.Test;

/**
 * @author Create By legend
 * @date 2019/3/22 10:24
 *
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，
 * 在数组中查找指定元素。给定一个整数数组A及它的大小n，同时给定要查找的元素val，
 * 请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。
 * 若该元素出现多次，请返回第一次出现的位置。
 */
public class Two {
    public static void main(String[] args){
        int A[] = { 14, 4, 5, 5, 5, 5 };
        int val = 5;
        sort(A);
        int pos = getPos(A, A.length, val);
        System.out.println("第一次出现的位置:"+pos);

        /*int[] arr = {1,2,4,5,1,4};
        int k = 9;
        int n = 6;
        int i = MyBinarySearch(arr, k);
        System.out.println(""+i);*/
    }

    //先给数组排序
    public static void sort(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int j = 0; j < i; j++) {
                if (arr[i]<arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        /*for (int i = 0; i < arr.length; i++) {
           // arr[]
            System.out.println(arr[i]);
        }*/
    }

    //获取位置
    public static int getPos(int[] A, int n, int val) {
        int low = 0;//数组的第一个位置
        int high = n-1;//数组的最后一个位置
        int mid;//数组的中间位置

        //没有/空
        if (n == 0 || A ==null)
            //返回-1
            return -1;

        while (low <= high){
            //获取到中间值下标
            mid = (low+high)/2;

            if (val == A[mid]){
                for (int j = mid; j >=0 ; j--) {
                    if (A[j]!=A[mid]){
                        mid = j+1;
                        break;
                    }
                    else if (A[j] ==A[mid]){
                        mid = j;
                        continue;
                    }
                }
                return mid;
            }else if (val<A[mid])
                high = mid-1;
            else
                low = mid +1;
        }
        return -1;
    }

    public void method(){
        //查找值
        int val = 1;

        int[] s = {4,1,2,8,33,1};

        int index = 0;

        //0--数组长度一半区间查找
        for (int i = 0; i <= s.length/2; i++) {
            System.out.print(""+s[i]);
            //区间一半位置到末尾开始查找
            for (int j=s.length/2+1;i<s.length;j++){
                //两边同时开始查找
                if (s[i]==val && s[j]==val){
                    s[index]=s[i];
                    index++;
                }
            }

        }
    }

}
