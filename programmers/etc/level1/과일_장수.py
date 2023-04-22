def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)
    for i in range(0, len(score), m):
        tmp = score[i:i+m]
        if len(tmp) == m:
            answer += tmp[m-1]*m
    return answer


k, m = 3, 4
score = [1, 2, 3, 1, 2, 3, 1]
print(solution(k, m, score)) # 8

k, m = 4, 3
score = [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]
print(solution(k, m, score)) # 33
