SELECT ANIMAL_TYPE, COALESCE(NAME,'No name') NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY animal_id;

/* ORACLE
SELECT ANIMAL_TYPE, COALESCE(NAME,'No name') NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY animal_id;
*/
