package com.legend.copy.domain4;

import java.io.Serializable;

/**
 * 用户(实现Serializable)
 */
public class User4 implements Serializable {
    private String name;
    private Address4 address4;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address4 getAddress() {
        return address4;
    }

    public void setAddress(Address4 address4) {
        this.address4 = address4;
    }

    public User4() {
    }

    public User4(String name, Address4 address4) {
        this.name = name;
        this.address4 = address4;
    }

    @Override
    public String toString() {
        return "User4{" +
                "name='" + name + '\'' +
                ", address4=" + address4 +
                '}';
    }
}
