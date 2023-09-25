SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') SALES_DATE,PRODUCT_ID,USER_ID,SALES_AMOUNT
FROM ONLINE_SALE 
WHERE MONTH(SALES_DATE)=3 
UNION ALL
SELECT DATE_FORMAT(SALES_DATE,'%Y-%m-%d') SALES_DATE,PRODUCT_ID,NULL,SALES_AMOUNT
FROM OFFLINE_SALE 
WHERE MONTH(SALES_DATE)=3 
ORDER BY 1,2,3;
