from heapq import *

def solution(k, score):
    answer = []
    q = []
    for s in score:
        heappush(q, s)
        if len(q) == k+1:
            heappop(q)
        answer.append(q[0])
    return answer


k = 3
score = [10, 100, 20, 150, 1, 100, 200]
print(solution(k, score)) # [10, 10, 10, 20, 20, 100, 100]

k = 4
score = [0, 300, 40, 300, 20, 70, 150, 50, 500, 1000]
print(solution(k, score)) # [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]
