# 实现字符串的反转及替换
```
public class test {

    //字符串反转
    public static String reverseStr(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args){
        String str = reverseStr("JavaHAND");
        System.out.println("反转后:"+str);
    }
}
```
>实现思路:递归调用截取函数
