# ʵ���ַ����ķ�ת���滻
```
public class test {

    //�ַ�����ת
    public static String reverseStr(String str){
        if(str == null || str.length() <= 1){
            return str;
        }
        return reverseStr(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args){
        String str = reverseStr("JavaHAND");
        System.out.println("��ת��:"+str);
    }
}
```
>ʵ��˼·:�ݹ���ý�ȡ����
