# ����
## List �� Set ����
- List����
```
1.���������ظ��Ķ���
2.���Բ�����nullԪ�ء�
3.��һ������������������ÿ��Ԫ�صĲ���˳�������˳����ǲ����˳��
4.���õ�ʵ������ ArrayList��LinkedList �� Vector��ArrayList ��Ϊ���У����ṩ��ʹ��������������ʣ���
LinkedList ����ھ�����Ҫ�� List ����ӻ�ɾ��Ԫ�صĳ��ϸ�Ϊ���ʡ�

ArrayList �ײ�������ʽ
LinkedList �ײ�˫������
Vector	�ײ����飬�̰߳�ȫ
```

- Set����
```
1.�������ظ�����

2.�������������޷���֤ÿ��Ԫ�صĴ洢˳��TreeSetͨ��Comparator����Comparableά����һ������˳��

3.ֻ����һ��nullԪ��
4.Set �ӿ������еļ���ʵ������ HashSet��LinkedHashSet �Լ� TreeSet�������е��ǻ��� HashMap
ʵ�ֵ� HashSet��TreeSet ��ʵ���� SortedSet �ӿڣ���� TreeSet ��һ�������� compare() ��
compareTo() �Ķ���������������������

```


- ����
```
1.List��Set���ǽӿڼ̳���Collection�ӿڡ�

2.���Ĳ�ͬ����List�ǿ����ظ��ģ���set�ǲ����ظ���,(ע�⣺Ԫ����Ȼ�޷���˳�򣬵���Ԫ����set�е�λ�����ɸ�Ԫ�ص�HashCode�����ģ���λ���ǹ̶���)

3.List�ӿ�������ʵ���ࣺLinkedList��ArrayList��Vector��Set�ӿ�������ʵ���ࣺHashSet���ײ���HashMapʵ�֣���LinkedHashSet

4.List�ʺϾ���׷�����ݣ����룬ɾ�����ݣ��������ȡ��Ч�ʱȽϵ�

5.Set�ʺϾ���������棬���룬ɾ���������ڱ���ʱЧ�ʱȽϵ�
```

## List �� Map ����
```
һ���Ǵ洢�������ݵļ��ϣ���һ���Ǵ洢����ֵ������˫�����ݵļ��ϣ�

List�д洢������ʱ��˳�򣬲��������ظ���

Map�д洢��������û��˳��ģ�����ǲ����ظ��ģ�����ֵ�ǿ������ظ��ġ�
```


## Arraylist �� LinkedList ����
```
1.ArrayList��ʵ���˻��ڶ�̬��������ݽṹ��LinkedList������������ݽṹ����LinkedList��˫��������nextҲ��previous��

2.�����������get��set��ArrayList����LinkedList����ΪLinkedListҪ�ƶ�ָ��

3.����������ɾ������add��remove��LinkedList�Ƚ�ռ���ƣ���ΪArrayListҪ�ƶ�����

4.ArrayList��LinkedList�����������࣬���ڴ洢һϵ�еĶ������á��������ǿ�����ArrayList���洢һϵ�е�String����Integer��
```
## ArrayList �� Vector ����
```
1.Vector�ķ�������ͬ����(Synchronized),���̰߳�ȫ�ģ���ArrayList�ķ������ǣ������̵߳�ͬ����ȻҪӰ�����ܣ����,ArrayList�����ܱ�Vector�á� 

2.��Vector��ArrayList�е�Ԫ�س������ĳ�ʼ��Сʱ,Vector�Ὣ������������,��ArrayListֻ����50%�Ĵ�С������,ArrayList�������ڽ�Լ�ڴ�ռ䡣
```

## HashMap �� Hashtable ������
>HashMap��Hashtable��ʵ����Map�ӿڣ�����������һ��֮ǰ��ҪŪ�������֮��ķֱ���Ҫ�������У��̰߳�ȫ�ԣ�ͬ��(synchronization)���Լ��ٶȡ�


- �̳еĸ��಻ͬ
```
Hashtable�̳���Dictionary�࣬��HashMap�̳���AbstractMap�ࡣ�����߶�ʵ����Map�ӿڡ�
```

- �̰߳�ȫ�Բ�ͬ
```
HashMap�Ƿ�synchronized����Hashtable��synchronized������ζ��Hashtable���̰߳�ȫ�ģ�����߳̿��Թ���һ��Hashtable�������û����ȷ��ͬ���Ļ�������߳��ǲ��ܹ���HashMap�ġ�Java 5�ṩ��ConcurrentHashMap������HashTable���������HashTable����չ�Ը��á�

����Hashtable���̰߳�ȫ��Ҳ��synchronized�������ڵ��̻߳���������HashMapҪ��������㲻��Ҫͬ����ֻ��Ҫ��һ�̣߳���ôʹ��HashMap����Ҫ�ù�Hashtable��
```

- �Ƿ��ṩContains����
```
HashMap��Hashtable��contains����ȥ���ˣ��ĳ�containsValue��containsKey


Hashtable������contains��containsValue��containsKey��������������contains��containsValue������ͬ��
```

- key��value�Ƿ�����nullֵ
```
HashMap���Խ���Ϊnull�ļ�ֵ(key)��ֵ(value)����HashTable����
```

- ����������ʽ���ڲ�ʵ���ϲ�ͬ
```
HashMap�ĵ�����(Iterator)��fail-fast����������Hashtable��enumerator����������fail-fast�ġ����Ե��������̸߳ı���HashMap�Ľṹ�����ӻ����Ƴ�Ԫ�أ��������׳�ConcurrentModificationException���������������remove()�����Ƴ�Ԫ���򲻻��׳�ConcurrentModificationException�쳣
```

- Hashֵ��ͬ
```
��ϣֵ��ʹ�ò�ͬ��HashTableֱ��ʹ�ö����hashCode����HashMap���¼���hashֵ��

 hashCode��jdk���ݶ���ĵ�ַ�����ַ������������������int���͵���ֵ��
```

- �ڲ�ʵ��ʹ�õ������ʼ�������ݷ�ʽ��ͬ
```
  HashTable�ڲ�ָ������������µ�Ĭ������Ϊ11����HashMapΪ16��Hashtable��Ҫ��ײ����������һ��ҪΪ2���������ݣ���HashMap��Ҫ��һ��Ϊ2���������ݡ�
      Hashtable����ʱ����������Ϊԭ����2����1����HashMap����ʱ����������Ϊԭ����2����
      Hashtable��HashMap���������ڲ�ʵ�ַ�ʽ������ĳ�ʼ��С�����ݵķ�ʽ��HashTable��hash����Ĭ�ϴ�С��11�����ӵķ�ʽ�� old*2+1��
```



## HashSet �� HashMap ����



* HashMap �� ConcurrentHashMap ������


## HashMap �Ĺ���ԭ������ʵ��
```
HashMap��������һ��Entry���顣Entry��HashMap�Ļ�����ɵ�Ԫ��ÿһ��Entry����һ��key-value��ֵ��
```
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319200414388-1155385160.jpg)

```
HashMap������+������ɵģ�������HashMap�����壬����������ҪΪ�˽����ϣ��ͻ�����ڵģ������λ��������λ�ò���������ǰ��entry��nextָ��null������ô���ڲ��ң���ӵȲ����ܿ죬����һ��Ѱַ���ɣ������λ���������������������Ӳ�������ʱ�临�Ӷ���ȻΪO(1),��Ϊ���µ�Entry����������ͷ��������Ҫ�򵥸ı�
```


```
��ϣ��hash table��Ҳ��ɢ�б���һ�ַǳ���Ҫ�����ݽṹ��Ӧ�ó�������ḻ����໺�漼��������memcached���ĺ�����ʵ�������ڴ���ά��һ�Ŵ�Ĺ�ϣ����HashMap��ʵ��ԭ��Ҳ���������ڸ�����������У���Ҫ�Կɼ�һ�ߡ����Ļ��java���Ͽ���еĶ�Ӧʵ��HashMap��ʵ��ԭ����н��⣬Ȼ����JDK7��HashMapԴ����з�����
```


## ConcurrentHashMap �Ĺ���ԭ������ʵ��
![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319195410347-2050784933.jpg)

```
��HashTable���ܲ���Ҫ���������в�����Ҫ����ͬһ������������������ж������ÿһ������һ�����ݣ������ڶ��̷߳���ʱ��ͬ�ε�����ʱ���Ͳ�������������ˣ������������Ч����߲���Ч�ʡ������ConcurrentHashMap�����õ�"�ֶ���"˼�롣
```

![](https://img2018.cnblogs.com/blog/1231979/201903/1231979-20190319195702339-1622839842.jpg)

- ConcurrentHashMapԴ�����
>ConcurrentHashMap�����˷ǳ������"�ֶ���"���ԣ�ConcurrentHashMap�������Ǹ�Segment���顣

```
final Segment<K,V>[] segments;
```