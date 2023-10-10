import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(arr, n):
    global cnt
    for i in arr[n]:
        if not visited[i]:
            visited[i] = True
            cnt += 1
            dfs(arr, i)


N, M = map(int, input().split())
bigger = [[] for _ in range(N+1)]
smaller = [[] for _ in range(N+1)]
mid = (N+1)/2

for _ in range(M):
    a, b = map(int, input().split())
    bigger[b].append(a)
    smaller[a].append(b)

answer = 0

for i in range(1, N+1):
    visited = [False]*(N+1)
    
    cnt = 0
    dfs(bigger, i)
    if cnt >= mid:
        answer += 1
    
    cnt = 0
    dfs(smaller, i)
    if cnt >= mid:
        answer += 1


print(answer)
