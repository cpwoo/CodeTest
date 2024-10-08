WITH FISH_MAX AS (
    SELECT MAX(LENGTH) MAX_LENGTH, FISH_TYPE
    FROM FISH_INFO 
    GROUP BY FISH_TYPE
)

SELECT i.ID, n.FISH_NAME, m.MAX_LENGTH LENGTH
FROM FISH_MAX m
JOIN FISH_INFO i ON m.FISH_TYPE = i.FISH_TYPE AND m.MAX_LENGTH = i.LENGTH
JOIN FISH_NAME_INFO n ON m.FISH_TYPE = n.FISH_TYPE
ORDER BY i.ID;
