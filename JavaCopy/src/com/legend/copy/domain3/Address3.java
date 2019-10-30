package com.legend.copy.domain3;

import java.io.Serializable;

/**
 * 地址2 (实现Serializable)
 */
public class Address3 implements Serializable {
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

    public Address3() {
    }

    public Address3(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address3{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
