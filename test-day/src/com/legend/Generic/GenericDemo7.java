package com.legend.Generic;

//泛型数组
public class GenericDemo7 {
    public static void main(String[] args){
       String[] arr = new String[]{"www","hand","com"};

       Integer[] arr2 = {1,2,3};
       tell(arr);
       tell(arr2);
    }

    //泛型数组
    private static <T>void tell(T arr[]) {
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
