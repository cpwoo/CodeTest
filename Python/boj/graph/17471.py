import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(g):
    q = deque()
    check = [False]*n
    q.append(g[0])
    check[g[0]] = True

    cnt, answer = 1, 0
    while q:
        tmp = q.popleft()
        answer += arr[tmp]
        for i in graph[tmp]:
            if i in g and not check[i]:
                check[i] = True
                cnt += 1
                q.append(i)

    if cnt == len(g):
        return answer
    else:
        return False

def dfs(cnt, x, end):
    global _min

    if cnt == end:
        g1, g2 = deque(), deque()

        for i in range(n):
            if visited[i]:
                g1.append(i)
            else:
                g2.append(i)

        ans1 = bfs(g1)
        if not ans1: return
        
        ans2 = bfs(g2)
        if not ans2: return

        _min = min(_min, abs(ans1-ans2))
        return

    for i in range(x, n):
        if visited[i]:
            continue

        visited[i] = True
        dfs(cnt+1, i, end)
        visited[i] = False


n = int(input())
arr = list(map(int, input().split()))
graph = [[] for _ in range(n)]
for i in range(n):
    lst = list(map(int, input().split()))
    for j in lst[1:]:
        graph[i].append(j-1)

_min = int(1e9)
for i in range(1, n//2+1):
    visited = [False]*n
    dfs(0, 0, i)

print(-1 if _min == int(1e9) else _min)
