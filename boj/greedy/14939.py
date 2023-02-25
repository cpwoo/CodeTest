import sys
input = lambda: sys.stdin.readline().rstrip()

from copy import deepcopy

dx, dy = [-1, 1, 0, 0, 0], [0, 0, 0, -1, 1]

# 전구 바꿔주기 편하게 True, False 로 변경
table = []
for i in range(10):
    tmp = list(input())
    for j in range(10):
        if tmp[j] == "O":
            tmp[j] = True
            continue
        tmp[j] = False
    table.append(tmp)

ans = 101

for f in range(1<<10):
    a = deepcopy(table)
    cnt = 0
    
    # 1열 check
    for x in range(10):
        if f & (1<<x):
            cnt += 1
            for k in range(5):
                nx, ny = x+dx[k], 0+dy[k]
                if (0 <= nx < 10) and (0 <= ny < 10):
                    a[ny][nx] = not a[ny][nx]
    
    # 나머지 열은 위의 열 보고 check
    for y in range(1, 10):
        for x in range(10):
            if not a[y-1][x]: continue
            for k in range(5):
                nx, ny = x+dx[k], y+dy[k]
                if (0 <= nx < 10) and (0 <= ny < 10):
                    a[ny][nx] = not a[ny][nx]
            cnt += 1
    
    # 마지막 열 켜져있으면 -1
    flag = True
    for i in range(10):
        if a[9][i] == True:
            flag = False
    
    if flag:
        ans = min(ans, cnt)


print(ans if ans != 101 else -1)
