package com.legend.JSON;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;

/**
 * @author Create By legend
 * @date 2019/3/21 11:29
 */
public class GsonTest {
    public static void main(String[] args){
        JsonParser parser = new JsonParser();
        try {
            JsonObject object = (JsonObject) parser.parse(new FileReader("src/com/legend/JSON/test.json"));
            System.out.println("="+object.get("cat"));//获取的是值所有的内容包括双引号

            System.out.println("cat="+object.get("cat").getAsString());
            System.out.println("pop="+object.get("pop").getAsBoolean());

            JsonArray array = object.getAsJsonArray("languages");
            for (int i = 0; i < array.size(); i++) {
                System.out.println("-----------");
                //System.out.println(array.get(i));
                System.out.println("id="+array.get(i).getAsJsonObject().get("id"));
                System.out.println("ide="+array.get(i).getAsJsonObject().get("ide"));
                System.out.println("name="+array.get(i).getAsJsonObject().get("name "));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
