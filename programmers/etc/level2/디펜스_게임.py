from heapq import *

def solution(n, k, enemy):
    answer = 0
    total = 0
    q = []
    
    for e in enemy:
        heappush(q, -e)
        total += e
        if total > n:
            if k == 0: break
            total += heappop(q)
            k -= 1
        answer += 1
        
    return answer


n, k = 7, 3
enemy = [4, 2, 4, 5, 3, 3, 1] # 5

n, k = 2, 4
enemy = [3, 3, 3, 3] # 4
