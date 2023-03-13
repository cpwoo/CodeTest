import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

from collections import deque

def circulation_station(start, idx, cnt):
    global cycle
    if start == idx and cnt >= 2:
        cycle = True
        return
    visited[idx] = True
    for i in info[idx]:
        if not visited[i]:
            circulation_station(start, i, cnt+1)
        elif i == start and cnt >= 2:
            circulation_station(start, i, cnt)

def distance_station():
    global check
    q = deque()
    for i in range(n):
        if cycle_station[i]:
            check[i] = 0
            q.append(i)
    while q:
        now = q.popleft()
        for i in info[now]:
            if check[i] == -1:
                q.append(i)
                check[i] = check[now]+1
    return check


n = int(input())
info = [[] for _ in range(n)]
cycle_station = [False] * n
check = [-1] * n

for _ in range(n):
    a, b = map(int, input().split())
    info[a-1].append(b-1)
    info[b-1].append(a-1)

for i in range(n):
    visited = [False]*n
    cycle = False
    circulation_station(i, i, 0)
    if cycle:
        cycle_station[i] = True

print(*distance_station())
