import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def solve():
    N, P = map(int, input().split())

    flow = [[0]*N for _ in range(N)]
    capacity = [[0]*N for _ in range(N)]
    connect = [[] for _ in range(N)]

    for _ in range(P):
        a, b = map(int, input().split())
        a -= 1; b -= 1
        connect[a].append(b)
        connect[b].append(a)
        capacity[a][b] = 1
    
    start, end = 0, 1
    answer = 0
    while True:
        prev = [-1]*N
        q = deque([start])
        while q:
            cur = q.popleft()
            if cur == end:
                break
            for nxt in connect[cur]:
                if capacity[cur][nxt]-flow[cur][nxt] > 0 and prev[nxt] == -1:
                    prev[nxt] = cur
                    q.append(nxt)
        
        if prev[end] == -1:
            break

        cur = end
        while cur != start:
            flow[prev[cur]][cur] += 1
            flow[cur][prev[cur]] -= 1
            cur = prev[cur]
        answer += 1
    
    print(answer)

solve()
