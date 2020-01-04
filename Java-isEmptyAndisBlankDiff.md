## isEmpty 和 isBlank 区别
`org.apache.commons.lang.StringUtils` 类提供了String的常用操作,最为常用的判空有如下：
- isEmpty(String str) 
- isBlank(String str)


### 分析
我们通过源码来分析区别：
```
public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
}

public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
}


public static boolean isBlank(String str) {
    int strLen;
    if (str != null && (strLen = str.length()) != 0) {
        for(int i = 0; i < strLen; ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    } else {
        return true;
    }
}

public static boolean isNotBlank(String str) {
    return !isBlank(str);
}
```

可以看到：
- StringUtils.isEmpty(String str) 判断某字符串是否为空，为空的标准是`str == null 或 str.length() == 0`
- StringUtils.isBlank(String str) 判断某字符串是否为空或长度为 0 或由空白符 (whitespace) 构成
- StringUtils.isNotEmpty(String str) 等价于 !isEmpty(String str)
- StringUtils.isNotBlan(String str) 等价于 !isBlank(String str)


>我自己更喜欢使用 StringUtils.isBlank(String str) 来执行判空操作，因为判断的条件更多更具体，特别是进行参数校验时，推荐使用。