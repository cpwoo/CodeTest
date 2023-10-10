from heapq import *

def solution(scoville, K):
    answer = 0
    q = []
    for s in scoville:
        heappush(q, s)
        
    while q[0] < K:
        if len(q) <= 1:
            return -1
        a = heappop(q)
        b = heappop(q)
        heappush(q, a+b*2)
        answer += 1
        
    return answer


scoville = [1, 2, 3, 9, 10, 12]
K = 7
print(solution(scoville, K)) # 2
