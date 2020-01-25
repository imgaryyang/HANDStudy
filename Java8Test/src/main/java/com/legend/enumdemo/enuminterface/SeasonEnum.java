package com.legend.enumdemo.enuminterface;

public enum SeasonEnum implements ISeasonBehaviour {

    SPRING(1,"春天"),

    SUMMER(2,"夏天"),

    FALL(3,"秋天"),

    WINTER(4,"冬天"),;

    /**
     * 成员变量
     */
    private int index;
    private String name;

    SeasonEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //接口方法
    @Override
    public void showSeasonBeauty() {
        System.out.println("welcome to " + this.name);
    }

    //接口方法
    @Override
    public String getSeasonName() {
        return this.name;
    }
}
