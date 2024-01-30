import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(row, visit):
    if row == N:
        return 0
    
    if visited[row][visit] != -1: # 이미 방문처리했으면 그대로 return
        return visited[row][visit]
    
    res = int(1e9)
    for i in range(N):
        if (visit & (1<<i)) != 0: # 같은 일을 맡으면 안 된다.
            continue
        res = min(res, dfs(row+1, (visit|(1<<i))) + tasks[row][i])
    
    visited[row][visit] = res

    return visited[row][visit]


N = int(input())
tasks = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1]*(1<<N) for _ in range(N)]
print(dfs(0, 0))
