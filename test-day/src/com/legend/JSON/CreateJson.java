package com.legend.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @author Create By legend
 * @date 2019/3/21 12:41
 *
 * Java创建Json数据
 */
public class CreateJson {
    public static void main(String[] args){
        //创建JSON对象
        JsonObject object = new JsonObject();
        object.addProperty("cat","id");

        //创建一个数组
        JsonArray array = new JsonArray();

        //创建对象
        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id","1");//设置参数
        lan1.addProperty("ide","Eclipse");
        lan1.addProperty("name","Java");

        //添加到数组中
        array.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id","2");
        lan2.addProperty("ide","Xcode");
        lan2.addProperty("name","C++");
        array.add(lan2);

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id","3");
        lan3.addProperty("ide","VScode");
        lan3.addProperty("name","Swift");
        array.add(lan3);

        //将数组添加到第一层结构
        object.add("languages",array);

        //创建最后一个根节点
        object.addProperty("pop",true);
        System.out.println(object.toString());
    }
}
