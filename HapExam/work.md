# HAP����ʱ���¼

## ��һ������ 2019.4.19
```
�����
�������ݿ⵼������
�����ĵ���Ϥ,�˽���Ҫ��������
��ṹ����
��������
ҳ��
```


### �����
```
����HAP��ܰ汾Ϊ3.4.0 �����ϴ

���ݿ��������
```


### ��������  --->���
```
1����ɫ���½�������ɫ������Ա�����۾���

2�����ܣ��½�һ�����ܣ����۶�������

3.�����۶������ܹҵ�������Ա���������۾�����ɫ��
```


### ҳ��--->���
```
������۶�������ҳ��

������۶�������ҳ���LOV��������
```

****
## �ڶ�---�������� 2019.4.20- 4.21
```
�������ĵ���ȡ����ģ��,��������

�޸����۶�������ҳ��

˼��:
	���۶�������ҳ�����ݼ���,������,���ݶ�����,��α�дmapper�ļ�


����������:
	�����۶�������ҳ�������в������Ƕ�Ӧĳ���������,����5��������ĳ���ֶε�����,����Mapper��sql����д����.

������:
	�½�һ��DTO�ļ�������5������Ȼ����mapper�ļ���ʹ�ù�������������.  (������)
	ҳ����������Ҫ������id�����½���DTOû��id����.
```

### �����ĵ�����
```
�鿴HapExam�ļ��������Analysis.md
```

### ����sql  (mapper.xml)
```
SELECT
	hooh.order_number,
	hoc.company_name,
	hac.customer_name,
	hooh.order_date,
	hooh.order_status,
	hool.ORDERD_QUANTITY * hool.unit_selling_price
FROM
	hap_org_companys hoc,
	hap_om_order_headers hooh,
	hap_ar_customers hac,
	hap_om_order_lines hool,
	hap_inv_inventory_items hiii
WHERE
	hoc.company_id = hac.company_id
AND hooh.customer_id = hac.customer_id
AND hool.header_id = hooh.header_id
AND hiii.INVENTORY_ITEM_ID = hool.INVENTORY_ITEM_ID


(
	SELECT
		sum(
			ORDERD_QUANTITY * unit_selling_price
		)
	FROM
		hap_om_order_lines line,hap_om_order_headers hooh
	WHERE
		line.header_id = hooh.header_id
)
```



## ������--->2019.4.22
```
�޸�����ҳ��,�����޸Ľ���,ҳ�涨��

��ɴ���ά��,��Ӣ���л�����

���Ժò�ѯ��������ҳ��,���ݼ��سɹ�

���Excel����,����������ĵ���Ҳ��ʹ��

�޸�����޷����ز���ʾ��bug
```


## ������--->2019.4.23
```
��ɱ���ͷ����Ϣ¼��

�޸�ҳ��֮�����ת�߼�

�޸������bug(sql)
```



## ������--->2019.4.24
```
���excel����

�޸�ɾ��ͷ����Ϣ����

Ȩ����Ӳ��� ����ά��
```
