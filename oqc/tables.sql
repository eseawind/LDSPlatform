/*******OQC*********/
--监装OQC检验结果记录
--监装OQC头表／DROID_OQC_DOCUMENT_HEADER/
CREATE TABLE ADM_MES.DROID_OQC_DOCUMENT_HEADER (
	DOCUMENT_HEADER_ID VARCHAR2(1000) NOT NULL,--主键ID
	DOCUMENT_NUMBER VARCHAR2(30) NOT NULL,--检验批号
	DOCUMENT_TYPE VARCHAR2(30) NOT NULL,--表单类型
	DOCUMENT_STATUS VARCHAR2(30) NOT NULL,--待检/归档
	--WORK_ORDER_ID NUMBER NOT NULL,--生产订单号
	INSPECTION_DATE DATE NOT NULL,--监装日期
	OUTBOUND_DELIVERY_NUMBER VARCHAR2(1000),--外向交货单号ID
	--CUSTOMER VARCHAR2(1000),--客户简称
	--SALES_ORDER_NUMBER VARCHAR2(1000),--销售订单号
	CABINET_NUMBER VARCHAR2(250),--柜号
	LOCK_NUMBER VARCHAR2(250),--锁号
	ACTUAL_SHIPMENT NUMBER,--实际出货数量
	RESULT_CODE VARCHAR2(30) NOT NULL,--判定结果(合格/不合格)
	INSPECTION_EXCEPTION VARCHAR2(3000),--异常现象
	INSPECTOR VARCHAR2(1000),--监装人员
	ATTR1 VARCHAR2(1000),--ATTR1
	ATTR2 VARCHAR2(1000),--ATTR2
	ATTR3 VARCHAR2(1000),--ATTR3
	ATTR4 VARCHAR2(1000),--ATTR4
	ATTR5 VARCHAR2(1000),--ATTR5
	CREATED_BY NUMBER NOT NULL,
	CREATION_DATE DATE NOT NULL,
	LAST_UPDATED_BY NUMBER NOT NULL,
	LAST_UPDATE_DATE DATE NOT NULL,
	LAST_UPDATE_LOGIN NUMBER,
	PRIMARY KEY (DOCUMENT_HEADER_ID)
);
/*
--监装OQC销售订单号表／DROID_OQC_SALE_ORDERS/
CREATE TABLE ADM_MES.DROID_OQC_SALE_ORDERS (
	SALE_ORDER_ID NUMBER NOT NULL,--销售订单ID
	DOCUMENT_HEADER_ID NUMBER NOT NULL,--头表ID
	SALES_ORDER_NUMBER VARCHAR2(1000),--销售订单号
	ATTR1 VARCHAR2(1000),--ATTR1
	ATTR2 VARCHAR2(1000),--ATTR2
	ATTR3 VARCHAR2(1000),--ATTR3
	ATTR4 VARCHAR2(1000),--ATTR4
	ATTR5 VARCHAR2(1000),--ATTR5
	CREATED_BY NUMBER NOT NULL,
	CREATION_DATE DATE NOT NULL,
	LAST_UPDATED_BY NUMBER NOT NULL,
	LAST_UPDATE_DATE DATE NOT NULL,
	LAST_UPDATE_LOGIN NUMBER,
	PRIMARY KEY (SALE_ORDER_ID)
);
*/
--监装OQC行表/DROID_OQC_DOCUMENT_LINE/
CREATE TABLE ADM_MES.DROID_OQC_DOCUMENT_LINE (
	DOCUMENT_LINE_ID VARCHAR2(1000) NOT NULL,
	DOCUMENT_HEADER_ID VARCHAR2(1000) NOT NULL,
	LEVEL_1 NUMBER NOT NULL,
	LEVEL_2 NUMBER,
	LEVEL_3 NUMBER,
	--OPTION_ID NUMBER NOT NULL,
	RESULT_CODE VARCHAR2(30) NOT NULL,
	RESULT_TEXT VARCHAR2(3000),
	ATTR1 VARCHAR2(1000),--ATTR1
	ATTR2 VARCHAR2(1000),--ATTR2
	ATTR3 VARCHAR2(1000),--ATTR3
	ATTR4 VARCHAR2(1000),--ATTR4
	ATTR5 VARCHAR2(1000),--ATTR5
	CREATED_BY NUMBER NOT NULL,
	CREATION_DATE DATE NOT NULL,
	LAST_UPDATED_BY NUMBER NOT NULL,
	LAST_UPDATE_DATE DATE NOT NULL,
	LAST_UPDATE_LOGIN NUMBER,
	PRIMARY KEY (DOCUMENT_LINE_ID)
);
--图片资源表/DROID_FND_RESOURCE/
CREATE OR REPLACE TABLE ADM_MES.DROID_OQC_RESOURCE( 
	RESOURCE_ID VARCHAR2(1000) NOT NULL, 
	DOCUMENT_HEADER_ID VARCHAR2(1000) NOT NULL,--头表ID
	FILE_NAME VARCHAR2(1000),
	CONTENT_TYPE VARCHAR2(1000),
	FILE_PATH VARCHAR2(1000),
	ATTR1 VARCHAR2(1000),--ATTR1
	ATTR2 VARCHAR2(1000),--ATTR2
	ATTR3 VARCHAR2(1000),--ATTR3
	ATTR4 VARCHAR2(1000),--ATTR4
	ATTR5 VARCHAR2(1000),--ATTR5
	CREATED_BY VARCHAR2(1000) NOT NULL, 
	CREATION_DATE VARCHAR2(1000) NOT NULL, 
	LAST_UPDATED_BY VARCHAR2(1000),
	LAST_UPDATED_DATE VARCHAR2(1000),
	PRIMARY KEY (RESOURCE_ID) 
);

http://192.168.0.88:8081/LDSPlatform-war/rest/oqc/create/header
{"inspectionDate":"2009-12-26  12:12","documentType":"OQC_J","inspectionException":"FFFF","outboundDeliveryNumber":"0080004778","actualShipment":"4444","createdBy":"0","lastUpdateLogin":"0","lastUpdatedBy":"0","attr2":"0010004259,","resultCode":"NG","attr1":"D018","cabinetNumber":"FF","documentNumber":"20141226000006","documentHeaderId":"b51dde9c-a669-4a34-8cda-3ca5da71eeab","lockNumber":"FF","documentStatus":"COMPLETE"}



