package com.legend.test;

import com.legend.enums.StatusEnum;

public class TestDemo4 {

    private static void test(int value) {
        switch (value) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("1");
                break;
            case 3:
                System.out.println("1");
                break;
            case 4:
                System.out.println("1");
                break;
            case 5:
                System.out.println("1");
                break;
            case 6:
                System.out.println("0");
                break;
            case 7:
                System.out.println("0");
                break;
            default:
                System.out.println("-1");
        }
    }


    public void test2() {
        /*switch (expression) {
            case value:
                //语句
                break;//可选
            case value:
                //语句
                break;//可选

            //你可以有任意数量的case语句

            default://可选
                //语句
        }*/
    }


    public void test3() {
        //使用包装类型
        Integer value = 3;
        switch (value) {
            case 1:
                System.out.println("1");
                //语句
                break;//可选
            case 3:
                System.out.println("3");
                //语句
                break;//可选

            //你可以有任意数量的case语句

            default://可选
                //语句
                System.out.println("default");
        }


        //使用枚举类型
        StatusEnum status = StatusEnum.PROCESSING;
        switch (status) {
            case OPEN:
                System.out.println("OPEN");
                //语句
                break;//可选
            case PROCESSING:
                System.out.println("PROCESSING");
                //语句
                break;//可选
            case CLOSE:
                System.out.println("CLOSE");
                //语句
                break;//可选

            //你可以有任意数量的case语句

            default://可选
                //语句
                System.out.println("default");
        }
    }
}
