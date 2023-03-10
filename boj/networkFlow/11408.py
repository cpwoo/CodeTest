import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

INF = sys.maxsize

def solve():
    N, M = map(int, input().split())

    start, end = 0, N+M+1
    L = end+1
    flow = [[0]*L for _ in range(L)]
    capacity = [[0]*L for _ in range(L)]
    cost = [[0]*L for _ in range(L)]
    connect = [[] for _ in range(L)]

    for i in range(1, N+1):
        connect[start].append(i)
        connect[i].append(start)
        capacity[start][i] = 1

        n, *lst = map(int, input().split())
        for k in range(0, n*2, 2):
            j, c = lst[k]+N, lst[k+1]
            connect[i].append(j)
            connect[j].append(i)
            capacity[i][j] = 1
            cost[i][j] = c
            cost[j][i] = -c
    
    for i in range(N+1, N+M+1):
        connect[i].append(end)
        connect[end].append(i)
        capacity[i][end] = 1

    answer = [0, 0]
    while True:
        prev = [-1]*L
        distance = [INF]*L
        visited = [False]*L
        q = deque([start])
        distance[start] = 0
        visited[start] = True
        while q:
            cur = q.popleft()
            visited[cur] = False
            for nxt in connect[cur]:
                if capacity[cur][nxt]-flow[cur][nxt] > 0 and distance[nxt] > distance[cur]+cost[cur][nxt]:
                    distance[nxt] = distance[cur]+cost[cur][nxt]
                    prev[nxt] = cur
                    if not visited[nxt]:
                        q.append(nxt)
                        visited[nxt] = True
        
        if prev[end] == -1: break

        cur = end
        while cur != start:
            flow[prev[cur]][cur] += 1
            flow[cur][prev[cur]] -= 1
            answer[1] += cost[prev[cur]][cur]
            cur = prev[cur]
        answer[0] += 1
    
    print(*answer, sep='\n')


solve()
