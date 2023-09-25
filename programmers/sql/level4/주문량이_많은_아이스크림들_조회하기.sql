SELECT FLAVOR
FROM (SELECT * FROM FIRST_HALF UNION ALL SELECT * FROM JULY) A
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;
