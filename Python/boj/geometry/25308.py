import sys
input = lambda: sys.stdin.readline().rstrip()

from math import sqrt

def check():
    for i in range(8):
        a, b, c = i, (i+1)%8, (i+2)%8
        if v[a]*v[c]*sqrt(2) > v[b]*(v[a]+v[c]):
            return False
    return True

def dfs(cnt):
    global ans
    if cnt == 8:
        ans += check()
        return
    for i in range(8):
        if visited[i]: continue
        visited[i] = True
        v[cnt] = arr[i]
        dfs(cnt+1)
        visited[i] = False


arr = list(map(int, input().split()))
v = [0]*8
visited = [False]*8

ans = 0
dfs(0)

print(ans)
