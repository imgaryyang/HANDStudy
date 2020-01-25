package com.legend.enumdemo.enummap;

import java.util.EnumMap;
import java.util.Map;

/**
 * enumMap 实现
 */
public class EnumTest {
    public static void main(String[] args) {
        Map<SeasonEnum, String> map = new EnumMap<SeasonEnum, String>(SeasonEnum.class);
        map.put(SeasonEnum.SPRING, "春天");
        map.put(SeasonEnum.SUMMER, "夏天");
        map.put(SeasonEnum.FALL, "秋天");
        map.put(SeasonEnum.WINTER, "冬天");

        System.out.println(map);
        System.out.println(map.get(SeasonEnum.SPRING));
    }
}
