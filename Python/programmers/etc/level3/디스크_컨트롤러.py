from heapq import *

def solution(jobs):
    answer = 0
    N = len(jobs)
    now, i = 0, 0
    start = -1
    q = []
    
    while i < N:
        for j in jobs:
            if start < j[0] <= now:
                heappush(q, [j[1], j[0]])
        if q:
            cur = heappop(q)
            start = now
            now += cur[0]
            answer += now-cur[1]
            i += 1
        else:
            now += 1
            
    return answer//N


jobs = [[0, 3], [1, 9], [2, 6]]
print(solution(jobs)) # 9
