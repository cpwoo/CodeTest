from heapq import *

def solution(operations):
    q, max_q = [], []
    for op in operations:
        cmd, num = op.split()
        num = int(num)
        if cmd == "I":
            heappush(q, num)
            heappush(max_q, -num)
        else:
            if q:
                if num == 1:
                    _max = heappop(max_q)
                    q.remove(-_max)
                else:
                    _min = heappop(q)
                    max_q.remove(-_min)                
                    
    return [-heappop(max_q), heappop(q)] if q else [0, 0]


operations = ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
print(solution(operations)) # [0, 0]

operations = ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]
print(solution(operations)) # [333, -45]
