package com.legend.copy.domain2;

/**
 * 地址2 (实现Cloneable,重写clone方法)
 */
public class Address2 implements Cloneable{
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address2() {
    }

    public Address2(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    protected Address2 clone() throws CloneNotSupportedException {
        return (Address2)super.clone();
    }

    @Override
    public String toString() {
        return "Address2{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
