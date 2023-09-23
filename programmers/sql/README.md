## 주의사항 정리

- WHERE 절에서 NULL Check는 IS NULL or IS NOT NULL로 판별 (비교연산자 사용 불가)

- WHERE 절에서 비교 Check는 비교 연산자로 판별 (IS or IS NOT 사용 불가)

- ORACLE에서 문자는 반드시 작은 따옴표로 감싸야 한다. (큰 따옴표는 오류 발생)

- SELECT에서 별칭을 준 건 ORDER BY 외에는 인식하지 못한다. 

    이는 연산 순서가 FROM - WHERE - GROUP BY - HAVING - SELECT - ORDER BY 이기 때문이다.
