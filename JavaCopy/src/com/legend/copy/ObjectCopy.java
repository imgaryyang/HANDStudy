package com.legend.copy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.legend.copy.domain.Address;
import com.legend.copy.domain.User;
import com.legend.copy.domain2.Address2;
import com.legend.copy.domain2.User2;
import com.legend.copy.domain3.Address3;
import com.legend.copy.domain3.User3;
import com.legend.copy.domain4.Address4;
import com.legend.copy.domain4.User4;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNotSame;


/**
 * Java对象拷贝测试
 */
public class ObjectCopy {


    @Test
    public void jacksonCopy() throws IOException {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 使用Jackson序列化进行深拷贝
        ObjectMapper objectMapper = new ObjectMapper();
        User copyUser = objectMapper.readValue(objectMapper.writeValueAsString(user), User.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }


    @Test
    public void gsonCopy() {

        Address4 address = new Address4("杭州", "中国");
        User4 user = new User4("大山", address);

        // 使用Gson序列化进行深拷贝
        Gson gson = new Gson();
        User4 copyUser = gson.fromJson(gson.toJson(user), User4.class);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        //输出
        System.out.println("user:"+user.toString());
        System.out.println("copyUser:"+copyUser.toString());

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }



    @Test
    public void serializableCopy() {

        Address3 address = new Address3("杭州", "中国");
        User3 user = new User3("大山", address);

        // 使用Apache Commons Lang序列化进行深拷贝
        User3 copyUser = (User3) SerializationUtils.clone(user);

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        //输出
        System.out.println("copyUser:"+copyUser.toString());
        System.out.println("user:"+user.toString());

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());

    }



    @Test
    public void cloneCopy() throws CloneNotSupportedException {

        Address2 address2 = new Address2("杭州", "中国");
        User2 user2 = new User2("大山", address2);

        // 调用clone()方法进行深拷贝
        User2 copyUser = user2.clone();

        // 修改源对象的值
        user2.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user2.getAddress().getCity(), copyUser.getAddress().getCity());

    }


    @Test
    public void constructorCopy() {

        Address address = new Address("杭州", "中国");
        User user = new User("大山", address);

        // 调用构造函数时进行深拷贝
        User copyUser = new User(user.getName(), new Address(address.getCity(), address.getCountry()));

        // 修改源对象的值
        user.getAddress().setCity("深圳");

        // 检查两个对象的值不同
        assertNotSame(user.getAddress().getCity(), copyUser.getAddress().getCity());
    }
}
