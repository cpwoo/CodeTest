import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(start, end, visited, start_cnt):
    q = deque([(start, start_cnt)])
    while q:
        now, cnt = q.pop()
        if now == end:
            if start_cnt == 0:
                break
            else:
                return cnt
        for nxt in adj_list[now]:
            if visited[nxt] == -1:
                visited[nxt] = now
                q.appendleft((nxt, cnt+1))
    path = [end]
    nxt = visited[end]
    while nxt != 0:
        path.append(nxt)
        nxt = visited[nxt]
    return path[:-1]

def solv():
    visited = [-1]*(n+1)
    visited[s] = 0
    path = bfs(s,e,visited,0)
    
    visited = [-1]*(n+1)
    for idx in path:
        visited[idx] = 1
    cnt = bfs(e,s,visited,len(path))
    print(cnt)


n, m = map(int, input().split())
adj_list = [[] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    adj_list[a].append(b)
    adj_list[b].append(a)

# 가장 중요
for idx in range(1, n+1):
    adj_list[idx].sort()
    
s, e = map(int, input().split())

solv()
