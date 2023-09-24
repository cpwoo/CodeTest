SELECT (PRICE - PRICE%10000) PRICE_GROUP, COUNT(*) PRODUCTS
FROM PRODUCT
GROUP BY (PRICE - PRICE%10000)
ORDER BY PRICE_GROUP;

/* ORACLE
SELECT TRUNC(PRICE, -4) PRICE_GROUP, COUNT(*) PRODUCTS
FROM PRODUCT
GROUP BY TRUNC(PRICE, -4)
ORDER BY PRICE_GROUP;
*/
