package com.legend.enumdemo.advantage;

/**
 * 枚举类的好处测试案例
 *
 * @author legend
 */
public class EnumTest {
    public static void main(String[] args) {

    }

    /**
     * 魔数
     *
     * @param orderStatus
     * @return
     */
    private boolean checkOrderFinish(int orderStatus) {
        if (3 == orderStatus) {
            //do something
            return true;
        }
        return false;
    }

    /**
     * 静态变量
     *
     * @param orderStatus
     * @return
     */
    private boolean checkOrderFinishForStatic(int orderStatus) {
        if (OrderStatus.FINISH == orderStatus) {
            //do something
            return true;
        }
        return false;
    }

    /**
     * 枚举
     *
     * @param orderStatus
     * @return
     */
    private boolean checkEnumOrderFinish(int orderStatus) {
        //订单已完成
        if (OrderStatusEnum.FINISH.getIndex() == orderStatus) {
            //do something
            return true;
        }
        return false;
    }


}