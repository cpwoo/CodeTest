import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

# 시작점과 끝점 분할 => 배열 길이 2배로 늘리기

def solve():
    N, P = map(int, input().split())
    M = 2*N

    flow = [[0]*M for _ in range(M)]
    capacity = [[0]*M for _ in range(M)]
    connect = [[] for _ in range(M)]

    for i in range(N):
        connect[i].append(i+N)
        connect[i+N].append(i)
        capacity[i][i+N] = 1

    for _ in range(P):
        a, b = map(int, input().split())
        a -= 1; b -= 1

        connect[a+N].append(b)
        connect[b].append(a+N)
        capacity[a+N][b] = 1

        connect[b+N].append(a)
        connect[a].append(b+N)
        capacity[b+N][a] = 1
    
    start, end = N, 1
    answer = 0
    while True:
        prev = [-1]*M
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
