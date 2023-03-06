import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def dfs(node):
    visited[node] = 1
    for nxt in graph[node]:
        if not visited[nxt]:
            dfs(nxt)
    stack.append(node)

def reverse_dfs(node, num):
    scc_num[node] = num
    scc_arr[num] += 1
    scc_val[num] += cash[node]
    for nxt in reverse_graph[node]:
        if scc_num[nxt] == -1:
            reverse_dfs(nxt, num)
        elif scc_num[node] != scc_num[nxt]:
            group[scc_num[nxt]].append(scc_num[node])


N, M = map(int, input().split())
graph = [[] for _ in range(N)]
reverse_graph = [[] for _ in range(N)]
visited = [0]*N
stack = []

for _ in range(M):
    a, b = map(int, input().split())
    graph[a-1].append(b-1)
    reverse_graph[b-1].append(a-1)

for i in range(N):
    if not visited[i]: dfs(i)

cash = [int(input()) for _ in range(N)]
scc_num, scc_arr, scc_val, group = [-1]*N, [], [], []

k = 0
while stack:
    now = stack.pop()
    if scc_num[now] == -1:
        group.append([])
        scc_arr.append(0)
        scc_val.append(0)
        reverse_dfs(now, k)
        k += 1

S, P = map(int, input().split())
S -= 1
result = list(map(int, input().split()))

q = deque()
q.append(scc_num[S])
dp = [0]*k
dp[scc_num[S]] = scc_val[scc_num[S]]

while q:
    now = q.popleft()
    for nxt in group[now]:
        if dp[nxt] < dp[now]+scc_val[nxt]:
            dp[nxt] = dp[now]+scc_val[nxt]
            q.append(nxt)

answer = 0
for r in result:
    answer = max(answer, dp[scc_num[r-1]])

print(answer)
