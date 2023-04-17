from heapq import *

def solution(food_times, k):
    answer = -1
    q = []
    for i, food_time in enumerate(food_times):
        heappush(q, (food_time, i+1))
    n = len(food_times)
    prev = 0

    while q:
        t = (q[0][0]-prev)*n
        if k >= t:
            k -= t
            prev, _ = heappop(q)
            n -= 1
        else:
            idx = k%n
            q.sort(key=lambda t: t[1])
            answer = q[idx][1]
            break

    return answer


food_times = [3, 1, 2]
k = 5
print(solution(food_times, k)) # 1

food_time = [1, 2, 3]
k = 4
print(solution(food_times, k)) # 3
