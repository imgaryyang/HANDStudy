package com.legend.copy.domain4;

import java.io.Serializable;

/**
 * 地址2 (Gson 序列化)
 */
public class Address4 implements Serializable {
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

    public Address4() {
    }

    public Address4(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address4{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
