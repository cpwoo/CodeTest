import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(start):
    if visited[start] == 1:
            return 0
    visited[start] = 1
    for i in range(1, n+1):
        if prey[start][i] == 1:
            if d[i] == 0 or dfs(d[i]):
                d[i] = start
                return 1
    return 0

n = int(input())
predator = [[]] + [list(map(int, input().split())) for _ in range(n)]
prey = [[0]*(n+1) for _ in range(n+1)]
d = [0]*(n+1)

for i in range(1, n+1):
    for j in range(1, n+1):
        if i == j:
            continue
        if predator[i][0] == predator[j][0] and predator[i][1] == predator[j][1] and predator[i][2] == predator[j][2] and i > j:
            continue
        if predator[i][0] >= predator[j][0] and predator[i][1] >= predator[j][1] and predator[i][2] >= predator[j][2]:
            prey[i][j] = 1

result = 0
for i in range(2):
    for j in range(1, n+1):
        visited = [0]*(n+1)
        dfs(j)

print(d[1:].count(0))
