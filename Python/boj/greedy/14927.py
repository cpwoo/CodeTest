import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

dx, dy = [-1, 1, 0, 0, 0], [0, 0, 0, -1, 1]

n = int(input())

table = [list(map(int, input().split())) for _ in range(n)]

ans = n**2+1

for f in range(1<<n):
    a = deepcopy(table)
    cnt = 0
    
    for x in range(n):
        if f & (1<<x):
            cnt += 1
            for k in range(5):
                nx, ny = x+dx[k], 0+dy[k]
                if (0 <= nx < n) and (0 <= ny < n):
                    a[ny][nx] = 1-a[ny][nx]
    
    for y in range(1, n):
        for x in range(n):
            if not a[y-1][x]: continue
            for k in range(5):
                nx, ny = x+dx[k], y+dy[k]
                if (0 <= nx < n) and (0 <= ny < n):
                    a[ny][nx] = 1-a[ny][nx]
            cnt += 1
    
    flag = True
    for i in range(n):
        if a[n-1][i]:
            flag = False
    
    if flag:
        ans = min(ans, cnt)

print(ans if ans != n**2+1 else -1)
