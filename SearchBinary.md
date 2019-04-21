 # 1.对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。

```
public class test {

    //排序
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


    //二分查找
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
        System.out.println("第一次出现的位置:"+pos);
    }
}
```
>注意:在二分查找中,数组已经是排好顺序的,而不是只有排好序的数组才可以使用二分查找