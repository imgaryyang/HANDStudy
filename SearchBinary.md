 # 1.����һ���������飬����ͨ�����ö��ֲ��ҵķ�ʽ����λĳһԪ�أ����д���ֲ��ҵ��㷨���������в���ָ��Ԫ�ء�����һ����������A�����Ĵ�Сn��ͬʱ����Ҫ���ҵ�Ԫ��val���뷵�����������е�λ��(��0��ʼ)���������ڸ�Ԫ�أ�����-1������Ԫ�س��ֶ�Σ��뷵�ص�һ�γ��ֵ�λ�á�

```
public class test {

    //����
    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i]<arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    //���ֲ���
    public static int findPos(int[] A,int n,int val){
        int low = 0;
        int high = n-1;
        int mid;
        while (low<high){
            mid = (low+high)/2;
            if (val == A[mid]){
                for (int i=mid;i>0;i--){
                    if (A[mid] == A[i]){
                        mid = i;
                    }
                }
                return mid;
            }

            if (val>A[mid]){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] A = {10,22,0,2,2,2,3,5,7,7,9,12,14};
        sort(A);
        int n = A.length;
        int pos = findPos(A, n, 22);
        System.out.println("��һ�γ��ֵ�λ��:"+pos);
    }
}
```
>ע��:�ڶ��ֲ�����,�����Ѿ����ź�˳���,������ֻ���ź��������ſ���ʹ�ö��ֲ���