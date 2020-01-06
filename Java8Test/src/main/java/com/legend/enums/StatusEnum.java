package com.legend.enums;

/**
 * 状态枚举第二种写法
 *
 * @author legend
 */
public enum StatusEnum {

    OPEN("OPEN"),
    PROCESSING("PROCESSING"),
    CLOSE("CLOSE"),
    ;

    private String code;

    StatusEnum(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
