SELECT S.HACKER_ID, H.NAME
FROM SUBMISSIONS S
    INNER JOIN CHALLENGES C ON S.CHALLENGE_ID = C.CHALLENGE_ID
    INNER JOIN DIFFICULTY D ON C.DIFFICULTY_LEVEL = D.DIFFICULTY_LEVEL
    INNER JOIN HACKERS H ON S.HACKER_ID = H.HACKER_ID
WHERE S.SCORE = D.SCORE
GROUP BY S.HACKER_ID, H.NAME
HAVING COUNT(S.CHALLENGE_ID) > 1
ORDER BY COUNT(S.CHALLENGE_ID) DESC, S.HACKER_ID;
