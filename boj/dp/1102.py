import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def solution():
    global n, p, time, now
    dp[now] = 0
    answer = 1000
    
    if p == 0 or time >= p:
        return 0
    elif time == 0:
        return -1
    else:
        q.append((now, 0))
    
    while time < p:
        size = len(q)
        for _ in range(size):
            now, cost = q.popleft()
            for i in range(n):
                if (1<<i) & now == 0:
                    tmp = int(1e9)
                    for j in range(n):
                        if (1<<j) & now == 1<<j:
                            tmp = min(tmp, graph[n-1-j][n-1-i])
                    if dp[now+(1<<i)] > cost+tmp:
                        q.append((now+(1<<i), cost+tmp))
                        dp[now+(1<<i)] = cost+tmp
        time += 1
    while q:
        _, cost = q.pop()
        answer = min(answer, cost)
    return answer


n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]
dp = [1000] * (1<<n) # 경우의 수
q = deque()

s = input()
p = int(input())

time = now = 0
for i in range(n):
    if s[-i-1] == "Y":
        now += 2**i
        time += 1

print(solution())
