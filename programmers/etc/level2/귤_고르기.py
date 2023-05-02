from collections import Counter

def solution(k, tangerine):
    answer = 0
    cnt = sorted(Counter(tangerine).values(), reverse=True)
    
    for c in cnt:
        k -= c
        answer += 1
        if k <= 0:
            break
    
    return answer


k = 6
tangerine = [1, 3, 2, 5, 4, 5, 2, 3]
print(solution(k, tangerine)) # 3

k = 4
tangerine = [1, 3, 2, 5, 4, 5, 2, 3]
print(solution(k, tangerine)) # 2

k = 2
tangerine = [1, 1, 1, 1, 2, 2, 2, 3]
print(solution(k, tangerine)) # 1
