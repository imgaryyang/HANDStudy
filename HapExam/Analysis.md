# HAP����
## ����

### 1.ǰ��׼��
```
1�����ݿ��������HAP_DEVģʽ�£���HAP_DEV�û���
2�����д�����HAP_DEVģʽ�£���HAP_DEV�û���
3������������HAP_DEVģʽ�£���HAP_DEV�û���
4�����������е�ҳ���ǩ����Ϣ��֧�ֶ�����
5�����˿������Ҫ���ֶ��Լ�����������,��ֹ�޸����ݿ���ṹ
```

### 2.�����б�
```
�����۶������������ܣ���Ҫ�������۶�������ҳ�漰��ϸҳ��
	1�����۶������ܲ�ѯҳ��
	2��¼�롢�༭���鿴���۶���ҳ��
	3���������۶�����Ϣ��Excel��ѡ����
	4�����۶������ݱ�����ӡ��ѡ����
	5����ťȨ�޿���
```

### 3.��������
```
1.��ɫ���½�������ɫ������Ա�����۾���
2.���ܣ��½�һ�����ܣ����۶�������
3.�����۶������ܹҵ�������Ա���������۾�������ɫ��
4.����״̬����ά��
```

- ����״̬ά��Լ��
```
���룺HAP_OM_ORDER_STATUS
���������۶���״̬
ֵ/���壺
		NEW/�½�,
		SUBMITED/���ύ,
		APPROVED/������,
		REJECTED/�Ѿܾ�
```


### 4. ���ݿ�
#### 4.1 �����ݱ�
```
��˾�����ݣ�HAP_ORG_COMPANYS
	����:COMPANY_ID

�ͻ������ݣ�HAP_AR_CUSTOMERS
	����:CUSTOMER_ID

���������ݣ�HAP_INV_INVENTORY_ITEMS
	����:INVENTORY_ITEM_ID
```

#### 4.2 ҵ�����ݱ�
```
���۶���ͷ��Ϣ:HAP_OM _ORDER_HEADERS
	����:HEADER_ID
	Ҫ��:HAP_OM_ORDER_HEADER _S	��1000��ʼ

���۶�������Ϣ:HAP_OM _ORDER_LINES
	����:LINE_ID
	Ҫ��:HAP_OM _ORDER_LINES_S	��1000��ʼ
```

#### 4.3 ���ݿ����Ĳ�������
```
ALTER TABLE `hap_om_order_headers` ADD PRIMARY KEY ( `HEADER_ID` ) 

ALTER TABLE `HAP _OM_ORDER_LINES` ADD PRIMARY KEY ( `LINE_ID` ) 

ALTER TABLE hap_om_order_headers AUTO_INCREMENT = 1000

ALTER TABLE hap_om_order_lines AUTO_INCREMENT = 1000
```


### 5. ���۶�������ҳ��
#### 5.1 ʵ�ֹ���
```
1.ʵ�ֶ�������ѯ���۶���
2.ͨ��������ŵ���鿴��༭���۶���
3.ʵ�֡���������ť��ת���۶�����ϸ������ж���¼��
4.ʵ��Excel�������۶�������
```

#### 5.2 ������Ƽ�����ʵ��
![](https://img2018.cnblogs.com/blog/1231979/201904/1231979-20190420090953854-1660540996.png)



#### 5.3.�������ܾ���ʵ��Ҫ��
##### 5.3.1 ���ڲ�ѯ��˾���ͻ������۶����š����ϡ�����״̬��ѯ���۶�������

- 1.��˾����
```
	LOV,��ʾ��˾����,���ڹ�˾ID���й�����ѯ
	
	LOV��ʽ
		��һ�й�˾����,�ڶ��й�˾����
```

- 2.�ͻ�����
```
	LOV,��ʾ�ͻ�����,���ڿͻ�ID���й�����ѯ,�������ѡ���˹�˾���ͻ�LOV����ʹ�ù�˾ѡ��ֵ�����޶�.


	LOV��ʽ
		��һ�пͻ�����,�ڶ��пͻ�����
```

- 3.���۶�����,��ͨ�ı��ֶ�

- 4.����
```
	LOV,��ʾ��������,��������ID���й�����ѯ

	LOV��ʽ
		��һ�����ϱ���,�ڶ�����������
```

- 5.����״̬
```
	1.����״̬�������б�����ʾ���������ڴ���ֵ���й�����ѯ����Ҫ��Դ��SYS_CODE_B,SYS_CODE_TL,SYS_CODE_VALUE_B,SYS_CODE_VALUE_TL����Ҫ��֤���ݵ���Ч�Լ�������
```


- 6.�������ݲ�ѯ
```
	1.����ѡ���Ĳ�ѯ������ѯ��صĶ�����Ϣ,��ʾ�ֶ���ͼGrid��ʾ����Ҫ��Ϣ���������۶����š���˾���ơ��ͻ����ơ��������ڡ�����״̬���������

	2.��ѯ����������ֻ�ܲ鿴�����ܱ༭�޸�
	
	3.������۶����ſɽ��뵽���۶�����ϸ������в鿴���޸� 
```

##### 5.3.2 ������������(����Excel)
```
���ݲ�ѯ���ɸѡ�������ڵ��������Excel�� ��ťʱ����������Excel�ĵ�
```

##### 5.3.3 ����½���ť���ж���¼��
```
������½�����ť ��ת��������ϸ������ж���¼�����
```

### 6.���۶�����ϸҳ��
#### 6.1 ʵ�ֹ���
```
1.ʵ������/����/�鿴���۶�������ֹ���۶�����ɾ��
2.���ݵ���״̬��ҳ����п��ƣ�ѡ����
3.ʵ�����۶������ݱ�����ӡ���ܣ�ѡ����
4.�����������ÿ��ư�ťȨ�ޣ�ѡ����
5.ʵ�ֶ�Tabҳǩ����
```

#### 6.2 ������Ƽ�����ʵ��
- ��Ҫ��������
![](https://img2018.cnblogs.com/blog/1231979/201904/1231979-20190420092712039-48644870.png)

- ����ҳ������
![](https://img2018.cnblogs.com/blog/1231979/201904/1231979-20190420092820360-1467306751.png)

>ע�⣺�����л�ɫ�ֶ�Ϊ���ɸ����ֶΣ���ɫΪ�����ֶΡ�


- ��Ҫ��Ϣ����
```
	����ͷ��Ϣ����˾���ơ��ͻ����ơ�������š��������ڡ�����״̬�������ܽ��ȡ�
	��������Ϣ���кš����ϱ�š�������������������λ�����۵��ۡ���������Ϣ
```
![](https://img2018.cnblogs.com/blog/1231979/201904/1231979-20190420093349400-1433442284.png)

>�����״̬����������Ŀ����߼�����Ծ��尴ť�ĸ��ӿ����߼����ġ���ť�����߼���С��




#### 6.3 ��������ʱ���ֶγ�ʼֵ��
```
1���������ڣ�Ĭ��Ϊ��ǰ����;
2������״̬��NEW���½���״̬.
4�������е��к�:���ڵ�ǰ����������к� + 1.
5���ύ���������ܾ�������ɾ�������ݴ�ӡ��ť������
```



### 6.4 ����ͷ����
- ��˾����
```
	�����ֶ�,ʹ��LOVѡ��,��Ҫ��Դ��HAP_ORG_COMPANYS,��Ҫ��֤���ݵ���Ч��.��̨���湫˾ID
```

- �ͻ����ƣ�
```
	�����ֶ�,ʹ��LOVѡ��,��Ҫ��Դ��HAP_AR_CUSTOMERS,��Ҫ��֤���ݵ���Ч��,�������ʹ�ù�˾ѡ��ֵ�����޶���ѡ���˹�˾,����ѡ���ͻ���
	
	LOV��ʽ:
		��һ�пͻ����룬�ڶ��пͻ�����
```


- �������:�����ֶ�,�ı�
- ��������
```
	�����ֶ�,ʹ������ѡ������ѡ��,Ҫ����������ֻ��ѡ��2016��������
```

- ����״̬
```
ͨ����ذ�ť�����ƶ�Ӧ��״̬��ֵ��
		NEW		�½�
	SUBMITED	���ύ
	APPROVED	������
	REJECTED	�Ѿܾ�
```

- �����ܽ��
```
	Ϊ�����н��Ļ���,ͬʱ����2λС��,�磺999.99
```

- �к�
```
	�����뱣֤����������Ψһ��,Ĭ�ϴ�����ǰ��������к�+1
```


- ���ϱ���
```
	�����ֶ�,ʹ��LOV,��Դ��HAP_INV_INVENTORY_ITEMS,ѡ�����������۵��������ݲ���֤���ݵ���Ч��
```

- ��������
```
���ɸ��ģ�ѡ�����ϱ�������
```
