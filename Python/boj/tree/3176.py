import sys
input = lambda: sys.stdin.readline().rstrip()

# dp 에 [부모, 최소, 최대] 저장
# 초기화 및 희소 테이블 계산
# 시간 최적화를 위해 2의 i승 단위로 빠르게 뛰어넘기 활용

from math import log2
from collections import deque

INF = sys.maxsize

N = int(input())
K = int(log2(N))+1
graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))
    graph[b].append((a, w))

q = deque()
q.append((1, 1))
depth = [0]*(N+1)
depth[1] = 1
dp = [[[0, 0, 0] for _ in range(K)] for _ in range(N+1)]

while q:
    idx, d = q.popleft()
    for nxt, w in graph[idx]:
        if not depth[nxt]:
            q.append((nxt, d+1))
            depth[nxt] = d+1
            dp[nxt][0] = [idx, w, w]

for j in range(1, K):
    for i in range(1, N+1):
        dp[i][j][0] = dp[dp[i][j-1][0]][j-1][0]
        dp[i][j][1] = min(dp[i][j-1][1], dp[dp[i][j-1][0]][j-1][1])
        dp[i][j][2] = max(dp[i][j-1][2], dp[dp[i][j-1][0]][j-1][2])


for _ in range(int(input())):
    a, b = map(int, input().split())
    _min, _max = INF, 0

    if depth[a] > depth[b]:
        a, b = b, a
    
    for i in range(K, -1, -1):
        if depth[b]-depth[a] >= (1<<i):
            _min = min(_min, dp[b][i][1])
            _max = max(_max, dp[b][i][2])
            b = dp[b][i][0]
    
    if a == b:
        print(_min, _max)
        continue

    for i in range(K-1, -1, -1):
        if dp[a][i][0] != dp[b][i][0]:
            _min = min(_min, dp[a][i][1], dp[b][i][1])
            _max = max(_max, dp[a][i][2], dp[b][i][2])
            a, b = dp[a][i][0], dp[b][i][0]

    _min = min(_min, dp[a][0][1], dp[b][0][1])
    _max = max(_max, dp[a][0][2], dp[b][0][2])
    print(_min, _max)
