SELECT DISTINCT NOW.N,
    CASE
        WHEN NOW.P IS NULL THEN 'Root'
        WHEN CHILD.P IS NULL THEN 'Leaf'
        ELSE 'Inner'
    END
FROM BST NOW
    LEFT JOIN BST CHILD ON NOW.N = CHILD.P
    LEFT JOIN BST PARENT ON NOW.P = PARENT.N
ORDER BY NOW.N;