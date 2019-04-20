# Java���Խ���
## 1 Java���������
### 1.1 Collection
- Collection �ӿ�
```
���Ͽ������Ϊһ����̬�Ķ������飬��ͬ���Ǽ����еĶ������ݿ�����������
```
- �����ص�
```
���ܸ�

������չ���޸�
```

- Collection�ĳ�������
```
List

Set

Queue
```


### 1.2 List
```
List�ӿڿ��Դ����������ݣ�������List�ӿ��������ǿ����ظ���
```

- List �ӿڳ�������
```
ArrayList

Vector
```

- ���ò���
```
�жϼ����Ƿ�Ϊ��:boolean isEmpty()

����ָ���Ķ����Ƿ���ڣ�int indexOf(Object o)
```

- ʵ�ʲ���
```
List<String> list = new ArrayList<>();//������ʽ
        list.add("a");//��Ӳ���

������ӡ����
for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+"\t");
        }

list.remove(4);//ɾ������

//�Ƿ�Ϊ��
System.out.println("\n"+list.isEmpty());

//����λ��   ���ڷ��ؾ���������������ڷ���-1
System.out.println(list.indexOf("b"));
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320143404787-1133426301.png)


### 1.3 Set
- ����
```
Set�ӿڲ��ܼ����ظ�Ԫ�أ����ǿ�������
```
- ��������
```
ɢ�д�ţ�HashSet

�����ţ�TreeSet
```

### 1.4 Iterator ������
- ��������ı�׼������
```
��׼������ʹ��Iterator�ӿ�
```

- ����ԭ��
```
Iterator��ר�ŵĵ�������ӿڣ�����������ǽ�Ԫ��һ���������ж�,�ж����Ƿ������ݣ��������������������
```
### 1.5 Map
- ������ʽ
```
key--->value �ķ�ʽ����
```

- ��������
```
HashMap�������ţ�key�������ظ�

Hashtable�������ţ�key�������ظ�
```

- ʵ�ʲ���
```
package com.legend.MapDemo;

import java.util.*;

public class MapDemo {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<>();
        map.put("name","HAND");
        map.put("time","2019");
        map.put("date","03");
        System.out.print(map.get("name")+"\t");//ͨ������ȡֵ

        //�жϼ��Ƿ����
        if(map.containsKey("time")){
            System.out.print(map.get("time")+"\n");
        }

        //�ж�ֵ�Ƿ����
        if(map.containsValue("time")){
            System.out.println("������ֵ");
        }

        //��ȡ���еļ�
        System.out.println("\n��ȡ���еļ�");
        Set<String> s = map.keySet();
        Iterator<String> it = s.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+"\t");
        }

        //��ȡ���е�ֵ
        System.out.println("\n��ȡ���е�ֵ");
        Collection<String> values = map.values();
        Iterator<String> v = values.iterator();
        while (v.hasNext()){
            System.out.print(v.next()+"\t");
        }
    }
}

```

## 2. Java�����ļ�����
### 2.1 File����
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153228441-682885773.png)


### 2.2 �ļ��Ĵ�����ɾ����������
```
File file = new File("pathname");//�����ļ�

file.delete();//ɾ��



//�ļ��нṹ���봦��ͬһ������
File f = new File("new Name");//�ļ��µ�����
file.renameTo(f);//������
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153746671-1472268786.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320153944869-356032689.png)


### 2.3 �ļ��еĴ�������������ɾ��
```
package com.legend.File;

import java.io.File;

public class FileFloderDemo {
    public static void main(String[] args){
        //�����·�����洴��Ҳ���ǵ�ǰ���� ��srcͬ��
        File floder = new File("HelloFloder");

        //�ļ��еĶ༶Ŀ¼����
        //floder.mkdirs();

        if (floder.mkdir()){
            System.out.println("�ļ��д����ɹ�");
        }else{
            if(floder.exists()){
                System.out.println("�ļ����Ѵ���");
            }else {
                System.out.println("�ļ��д���ʧ��");
            }
        }

        //�ļ���������
        //File f = new File("TestFloder");
        //floder.renameTo(f);

        //�ļ���ɾ��
        floder.delete();//һ���ǿ��ļ���
    }
}

```

### 2.4 �ļ����ԵĶ�ȡ
```
package com.legend.File;

import java.io.File;
import java.io.IOException;

public class ReadFileProp {
    public static void main(String[] args){
        //�����·�����洴��Ҳ���ǵ�ǰ���� ��srcͬ��
        File file = new File("new2.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //��ȡ�ļ��Ƿ����
        System.out.println(""+file.exists());

        //��ȡ�ļ���
        System.out.println(""+file.getName());

        //��ȡ�ļ�·��
        System.out.println(""+file.getPath());

        //��ȡ�ļ�����·��
        System.out.println(""+new File(file.getAbsolutePath()).getParent());

        //��ȡ�ļ�����·��
        System.out.println(""+file.getAbsolutePath());

        //�ж��ļ��Ƿ�����
        System.out.println(""+file.isHidden());

        //�ж��ļ��Ƿ�ɶ�
        System.out.println(""+file.canRead());

        //�ж��ļ��Ƿ��д
        System.out.println(""+file.canWrite());

        //��ȡ�ļ���С(��ȡ�����ֽ�)
        System.out.println(""+(float)file.length()/1000+"KB");

        //�ж��Ƿ�Ϊ�ļ���
        System.out.println(""+file.isDirectory());
    }
}

```


### 2.5 �ļ����Ե�����
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320161532167-1390300344.png)


### 2.6 �����ļ���
```
public static void scannerFile
{
        if (dir.isDirectory()){
            //��ǰ·���������ļ����ļ���
            File[] next = dir.listFiles();

            for(int i = 0; i < next.length; i++){
                for (int j = 0; j < tab; j++) {
                    System.out.print("|---");
                }
                System.out.println(next[i].getName());
                //������ļ�
                if (next[i].isDirectory()){
                    //�ļ��м���ѭ��
                    printFile(next[i],tab+1);
                }
            }
           /* for(int i = 0; i < next.length; i++){
                //������ļ�
                if (next[i].isFile()){
                    System.out.println(next[i].getName());
                }else{
                    //�ļ��м���ѭ��
                    printFile(next[i]);
                }
            }*/

        }
    }
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320164753767-138594024.png)

### 2.7 �ļ��ļ򵥶�д
- ��ȡ�ļ�
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320165611808-211041949.png)

>����һ��File����,�ڴ���һ��FileInputStream ���󣬴���File�����ڴ���һ��FileInputReader �����ļ����룬�������һ���ַ���BufferReader

 
- д���ļ�
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320165632673-917719961.png)

>����һ���ļ������FileOutputStream��Ȼ�󴴽�һ����������ڴ���һ��������


## 3 Java�е�IO����
### 3.1 IO���
```
IOҲ������I/O���������ΪIn��Out������������������ԣ�IO��ϵ�Ļ������ܾ��ǣ�����д
```

- IO��
```
���ã�
	��д�豸�ϵ����ݣ�Ӳ���ļ����ڴ桢���̡�����....

�������ݵ�����
	�������������

���ݴ������ݵ����ͣ�
	�ֽ������ַ���
```

- �ַ������ֽ���
```
�ֽ���
	���Դ����������͵����ݣ���MP3��ͼƬ�����֡��ڶ�ȡʱ������һ���ֽھͷ���һ���ֽڡ�
	��Java�ж�Ӧ���඼��"Stream"��β 

�ַ���
	���ܹ������ı����ݣ���txt�ı��ȡ��ڶ�ȡʱ������һ�������ֽڣ��Ȳ���ָ���ı����Ȼ�󽫲鵽���ַ����ء�
	��Java�ж�Ӧ���඼�ԡ�Reader����Writer����β
```

### 3.2 �ַ����ֽ������
- �ֽ�
```
һ���ֽڵ���8λ�����ƣ���һ��8λ������������һ���ܾ���Ĵ洢�ռ䡣
```

- �ַ�
```
�ַ�������ʹ�õļǺţ����������ϵ�һ������
```

- ����
```
�ַ���Ҳ��������
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320172953298-578431783.png)


### 3.3 ʹ���ֽ�����ȡ����
```
  FileInputStream fis = new FileInputStream("new2.txt");
            byte[] input = new byte[21];
            fis.read(input);
            String inputString = new String(input,"UTF-8");
            System.out.println(inputString);
```

### 3.4 ʹ�ô�������ֽ�����д����
```
{
        try {
            FileInputStream fis = new FileInputStream("new3.txt");

            FileOutputStream fos = new FileOutputStream("new3.txt");

            //�����ֽ���
            BufferedInputStream bis = new BufferedInputStream(fis);

            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] b = new byte[90];
            int count = 0;

            //��1970�굽���ڵ�ʱ��ĺ�����
            long before = System.currentTimeMillis();

            while (bis.read(b)!=-1){
                bos.write(b);
                count++;
            }
            bis.close();
            fis.close();
            System.out.println(count+"��");
            System.out.println(System.currentTimeMillis()-before+"ms");

            //String str = new String(b,"UTF-8");
            //System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```

### 3.5 ʹ���ַ�����д����


### 3.6 ʹ��ApacheIO����IO���ļ�
```
package com.legend.File.TestApacheIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

//ʹ��ApacheIO����IO
public class TestApacheIODemo {
    public static void main(String[] args){
        File file = new File("new4.txt");
        File newFile = new File("new5.txt");
        try {
            //���ļ�תΪ�ַ���
            String s = FileUtils.readFileToString(file, "UTF-8");
            System.out.println(s);

            //�����ļ�
            FileUtils.copyFile(file,newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

## 4.Java���̱߳��
### 4.1 �߳������
- �߳�
```
�����е���˳��Ŀ�����
	�̱߳������������������
	�߳��ǳ����е�˳�������,ֻ��ʹ�÷�����������Դ�ͻ���
```

- ����
```
ִ���еĳ���һ�����̿��԰���һ�������̣߳�һ����������Ҫ����һ���߳�
```

- ���߳�
```
������ֻ����һ���̣߳�ʵ��������������һ�����߳�
```

- ���߳�
```
���߳�����һ�����������ж������

���̵߳�Ŀ���Ǹ��õ�ʹ��CPU����Դ
```

### 4.2 �̵߳�ʵ��
- ��Java�У��̵߳�������2��
```
�̳�Thread��

ʵ��Runnable�ӿ�
```

- �̳�Thread��
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212800514-209399271.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212823334-1916911539.png)


- ʵ��Runnable��
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320212848658-1835640414.png)

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320213030878-1800173104.png)


![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190320213121063-1893100328.png)


### 4.3 �̵߳�״̬
```
����״̬��׼������һ�����̵߳Ķ���

����״̬��������start() �������ȴ�CPU���е���

����״̬��ִ��run����

����״̬����ʱִֹͣ�У����ܽ���Դ���������߳�ʹ��

��ֹ״̬������״̬���߳�����
```

### 4.4 �̵߳ĳ��÷���
- ȡ���߳�����   getName()

- ȡ�õ�ǰ�̶߳���  currentThread()
- �ж��߳��Ƿ�����  isAlive()
- �̵߳�ǿ������  join()
- �̵߳�����  sleep()
- �̵߳����� yield()

### 4.5 �̵߳����ȼ�
- ���ȼ�˳������
```
1-MIN_PRIORITY

10-MAX_PRIORITY

5-NORM_PRIORITY


���ʲô��������Ĭ��ֵ��5
```

### 4.6 �߳�ͬ��
- ͬ�������
```
�ڴ�����ϼ���synchronize�ؼ��֣���˴�����Ϊͬ�������
```
- ��ʽ
```
synchronize(ͬ������){
	��Ҫͬ���Ĵ����;
}

```
- ͬ������
```
���˴�������ͬ��������Ҳ�ǿ���ͬ����
```
- ����ͬ����ʽ

```
synchronize void ��������(){
}
```

### 4.7 �߳���������
```
New(����)��
Runnable(������)��Ϊ�˷�����������ɽ����Ϊ��Runnable��Running��
blocked(������)��
Dead(����)��
``` 
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190321085100329-861723380.png)

