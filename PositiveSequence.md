# 2. 输入一个正数n，输出所有和为n的连续正数序列。
```
public class test {

   //输入一个正数n，输出所有和为n的连续正数序列。
   public static void count(int n){
       int min = 1;
       int max = 1;
       int sum = 1;
       while (max<=n/2+1){
           if (n==sum){
               for (int i = min; i <= max; i++) {
                   System.out.print(i+" ");
               }
               System.out.println("");
               sum-=min;
               min++;
               max++;
               sum+=max;
           }

           if (n<sum){
               sum-=min;
               min++;
           }else{
               max++;
               sum+=max;
           }
       }

   }

    public static void main(String[] args){
        count(15);
    }
}
```
>实现思路:定义一个min  max指针还有一个计算统计的变量.先考虑当sum==n的时候的情况,然后min,max指针同时右移动,(记得先把原来的min数值减掉再移动min指针,max指针移动后再加回去,
后面就是简单左右指针的移动)