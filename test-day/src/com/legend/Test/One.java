package com.legend.Test;

import java.util.*;

/**
 * @author Create By legend
 * @date 2019/3/22 10:25
 */
public class One {

    //方法一
    public static char findFirstRepeat(String A,int n){
        HashSet hs = new HashSet();
        int length = A.length();

        //利用toCharArray()  将String类型转化为char类型
        char[] a = A.toCharArray();
        for (int i = 0; i < length; i++) {
            //通过往hashset塞值(HashSet不准有重复元素),判断当前一段数据中是否有重复元素,
            boolean b = hs.add(a[i]);

            //一旦有,立刻返回
            if (b == false){
                return a[i];
            }
        }

        return '0';
    }

    //方法二  Map
    public static void findFirstRepeat2(String A,int n){
        //新插入的key-value 给value赋初值都为1
        int sum = 1;

        Map<String,Integer> hashMap = new LinkedHashMap<String,Integer>();
        for (int i = 0; i < n; i++) {
            char item = A.charAt(i);
            String item2 = String.valueOf(item);
            String key = item2;

            boolean contains = hashMap.containsKey(key);
            if (contains){
                Integer value = hashMap.get(key);
                sum = value+1;

                hashMap.put(item2,sum);
            }else {
                sum = 1;
                hashMap.put(item2,sum);
            }
        }
        //输出Map中的信息
        System.out.println(hashMap);

        List<String> keyList = new ArrayList<String>();
        for (Map.Entry<String,Integer> e:hashMap.entrySet()) {
            if (e.getValue().equals(2)){
                keyList.add(e.getKey());
            }
        }
        for (String i:keyList) {
            System.out.println(i);
            break;
        }
    }

    public static void main(String[] args){
        String A = "abcca";
        int n = A.length();
        //char b = findFirstRepeat(A,n);
        //System.out.println(""+b);
        findFirstRepeat2(A,n);
        method();
    }



    //考试想法
    public static void method(){
        String str = "EAABBDVC";

        //转为数组
        char[] chars = str.toCharArray();

        //标记出现次数
        int index = 0;

        char[] c = new char[100];

        //循环统计出现次数,并标记
        for (int i = 0; i < chars.length ; i++) {
            for (int j=1;j< chars.length;j++){
                if (chars[i]==chars[j]){
                    c[index]=chars[i];
                    index++;
                }
            }

            //System.out.println(""+c[index]);
        }

        System.out.println(""+c[0]);
        /*//输出第一次出现的值
        for (int i = 0; i <c.length ; i++) {
            if (c[index]==c[index++]) {
                System.out.println(c[index]);
            }
        }*/
    }
}
