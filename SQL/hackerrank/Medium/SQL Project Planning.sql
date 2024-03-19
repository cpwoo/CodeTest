SET SQL_MODE = '';

SELECT START_DATE, END_DATE
FROM (
    SELECT START_DATE 
    FROM PROJECTS 
    WHERE START_DATE NOT IN (SELECT END_DATE FROM PROJECTS)) A,
    (
    SELECT END_DATE
    FROM PROJECTS
    WHERE END_DATE NOT IN (SELECT START_DATE FROM PROJECTS)) B
WHERE START_DATE < END_DATE
GROUP BY START_DATE
ORDER BY DATEDIFF(END_DATE, START_DATE), START_DATE;