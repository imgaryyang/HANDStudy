# 2. ����һ������n��������к�Ϊn�������������С�
```
public class test {

   //����һ������n��������к�Ϊn�������������С�
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
>ʵ��˼·:����һ��min  maxָ�뻹��һ������ͳ�Ƶı���.�ȿ��ǵ�sum==n��ʱ������,Ȼ��min,maxָ��ͬʱ���ƶ�,(�ǵ��Ȱ�ԭ����min��ֵ�������ƶ�minָ��,maxָ���ƶ����ټӻ�ȥ,
������Ǽ�����ָ����ƶ�)