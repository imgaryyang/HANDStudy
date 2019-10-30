package com.legend.copy.domain3;

import java.io.Serializable;

/**
 * 用户(实现Serializable)
 */
public class User3 implements Serializable {
    private String name;
    private Address3 address3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address3 getAddress() {
        return address3;
    }

    public void setAddress(Address3 address3) {
        this.address3 = address3;
    }

    public User3() {
    }

    public User3(String name, Address3 address3) {
        this.name = name;
        this.address3 = address3;
    }

    @Override
    public String toString() {
        return "User3{" +
                "name='" + name + '\'' +
                ", address3=" + address3 +
                '}';
    }
}
