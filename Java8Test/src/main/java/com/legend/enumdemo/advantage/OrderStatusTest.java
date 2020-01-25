package com.legend.enumdemo.advantage;

/**
 * enum-switch 相结合使用测试
 *
 * @author legend
 */
public class OrderStatusTest {
    public static void main(String[] args) {
        //改变订单状态
        changeByOrderStatus(OrderStatusEnum.FINISH);

    }

    /**
     * 改变订单状态
     *
     * @param orderStatusEnum
     */
    private static void changeByOrderStatus(OrderStatusEnum orderStatusEnum) {
        switch (orderStatusEnum) {
            case UNPAID:
                System.out.println("你下单了，赶紧付钱吧");
                break;
            case PAID:
                System.out.println("我已经付钱啦");
                break;
            case SEND:
                System.out.println("已发货");
                break;
            case FINISH:
                System.out.println("订单完成啦");
                break;
        }
    }
}
