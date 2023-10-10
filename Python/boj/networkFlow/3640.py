import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

INF = sys.maxsize

def solve():
    v, e = map(int, input().split())

    L = 2*v+1
    flow = [[0]*L for _ in range(L)]
    capacity = [[0]*L for _ in range(L)]
    cost = [[0]*L for _ in range(L)]
    connect = [[] for _ in range(L)]
    
    for i in range(1, v+1):
        connect[i].append(i+v)
        connect[i+v].append(i)
        capacity[i][i+v] = 1

    for _ in range(e):
        a, b, c = map(int, input().split())
        connect[a+v].append(b)
        connect[b].append(a+v)
        capacity[a+v][b] = 1
        cost[a+v][b] = c
        cost[b][a+v] = -c

    start, end = 1+v, v
    answer = 0
    # 경로 2개 => 2번 반복
    for _ in range(2):
        prev = [-1] * L
        distance = [INF] * L
        visited = [False] * L
        q = deque([start])
        distance[start] = 0
        visited[start] = True
        while q:
            cur = q.popleft()
            visited[cur] = False
            for nxt in connect[cur]:
                if capacity[cur][nxt]-flow[cur][nxt] > 0 and distance[nxt] > distance[cur]+cost[cur][nxt]:
                    distance[nxt] = distance[cur] + cost[cur][nxt]
                    prev[nxt] = cur
                    if not visited[nxt]:
                        q.append(nxt)
                        visited[nxt] = True

        cur = end
        while cur != start:
            flow[prev[cur]][cur] += 1
            flow[cur][prev[cur]] -= 1
            answer += cost[prev[cur]][cur]
            cur = prev[cur]
    
    print(answer)


while True:
    try:
        solve()
    except:
        break
