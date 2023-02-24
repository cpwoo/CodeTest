import sys
input = lambda: sys.stdin.readline().rstrip()

def dist(a, b):
    return ((a[0]-b[0])**2+(a[1]-b[1])**2)**0.5

def dfs(cur):
    for i in range(n):
        if dist(location[cur], location[i]) > (location[cur][2]+location[i][2]) or cur == i or visited[i]:
            continue
        visited[i] = True
        dfs(i)

for _ in range(int(input())):
    n = int(input())
    location = [list(map(int, input().split())) for _ in range(n)]
    visited = [False] * n

    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1
    print(answer)
