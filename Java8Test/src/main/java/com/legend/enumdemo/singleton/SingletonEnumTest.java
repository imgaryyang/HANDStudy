package com.legend.enumdemo.singleton;

/**
 * 枚举实现的单例
 *
 * @author legend
 */
public class SingletonEnumTest {

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.setName("legend@qichunlin");
        System.out.println(SingletonEnum.INSTANCE.getName());
    }


    public enum SingletonEnum {
        INSTANCE,
        ;

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
