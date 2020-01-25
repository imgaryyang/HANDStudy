package com.legend.enumdemo.advantage;

/**
 * 使用枚举类的好处案例
 *
 * @author legend
 */
public enum OrderStatusEnum {
    UNPAID(0, "未付款"),
    PAID(1, "已付款"),
    SEND(2, "已发货"),
    FINISH(3, "已完成"),
    ;

    private int index;

    private String desc;

    public int getIndex() {
        return index;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 构造器方法
     *
     * @param index
     * @param desc
     */
    OrderStatusEnum(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    /**
     * 普通方法
     */
    public static OrderStatusEnum of(int index) {
        for (OrderStatusEnum temp : values()) {
            if (temp.getIndex() == index) {
                return temp;
            }
        }
        return null;
    }
}