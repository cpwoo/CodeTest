SELECT BOOK_ID, DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') PUBLISHED_DATE
FROM BOOK
WHERE DATE_FORMAT(PUBLISHED_DATE, '%Y') = '2021' AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE;

/* ORACLE
SELECT BOOK_ID, TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD') PUBLISHED_DATE
FROM BOOK
WHERE TO_CHAR(PUBLISHED_DATE, 'YYYY') = '2021' AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE;
*/