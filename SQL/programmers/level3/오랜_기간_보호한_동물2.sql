SELECT O.ANIMAL_ID, O.NAME
FROM ANIMAL_INS I
RIGHT OUTER JOIN ANIMAL_OUTS O
ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.ANIMAL_ID IS NOT NULL
ORDER BY DATEDIFF(O.DATETIME,I.DATETIME)+1 DESC
LIMIT 2;
