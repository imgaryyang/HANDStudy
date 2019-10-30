package com.legend.copy.domain2;

/**
 * 用户(实现Cloneable,重写clone方法)
 */
public class User2 implements Cloneable{
    private String name;
    private Address2 address2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address2 getAddress() {
        return address2;
    }

    public void setAddress(Address2 address) {
        this.address2 = address;
    }

    public User2() {
    }

    public User2(String name, Address2 address2) {
        this.name = name;
        this.address2 = address2;
    }

    @Override
    public User2 clone() throws CloneNotSupportedException {
        User2 user = (User2) super.clone();
        user.setAddress(this.address2.clone());
        return user;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", address2=" + address2 +
                '}';
    }
}
