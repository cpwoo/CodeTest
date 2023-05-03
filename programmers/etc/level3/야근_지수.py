from heapq import *

def solution(n, works):
    q = []
    for w in works:
        heappush(q, -w)
    while n:
        if q[0] >= 0:
            break
        w = heappop(q)
        heappush(q, w+1)
        n -= 1
        
    return sum([i**2 for i in q])


works = [4, 3, 3]
n = 4
print(solution(works, n)) # 12

works = [2, 1, 2]
n = 1
print(solution(works, n)) # 6

works = [1, 1]
n = 3
print(solution(works, n)) # 0
