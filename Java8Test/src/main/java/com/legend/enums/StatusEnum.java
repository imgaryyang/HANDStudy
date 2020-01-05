package com.legend.enums;

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
