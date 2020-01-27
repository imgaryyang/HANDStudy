package com.legend.Test;

/**
 * @author Create By legend
 * @date 2019/3/22 14:14
 *
 * 10.	如何实现字符串的反转及替换？
 */
public class StringReverse {
    public static String reverse(String originStr){
        if (originStr == null || originStr.length()<=1){
            return originStr;
        }
        return reverse(originStr.substring(1))+originStr.charAt(0);
    }

    public static void main(String[] args){
        String s = reverse("demo");
        System.out.println(s);
    }
}
