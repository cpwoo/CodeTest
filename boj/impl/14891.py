import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

t = [deque(list(map(int, input()))) for _ in range(4)] # 톱니 상태

# 톱니 돌리기
for _ in range(int(input())):
    r = [] # 처음 톱니 상태
    for i in range(4):
        r.append([t[i][6], t[i][2]])
    n, d = map(int, input().split())
    n -= 1

    # 왼쪽 톱니 돌리기
    if n != 0:
        for i in range(n, 0, -1):
            if r[i][0] != r[i-1][1]:
                if (n-(i-1))%2 == 0:
                    t[i-1].rotate(d)
                elif (n-(i-1))%2 != 0:
                    t[i-1].rotate(-1*d)
            elif r[i][0] == r[i-1][1]:
                break
    
    # 오른쪽 톱니 돌리기
    if n != 3:
        for i in range(n, 3):
            if r[i][1] != r[i+1][0]:
                if (n-(i+1))%2 == 0:
                    t[i+1].rotate(d)
                elif (n-(i+1))%2 != 0:
                    t[i+1].rotate(-1*d)
            elif r[i][1] == r[i+1][0]:
                break
    
    t[n].rotate(d)

# 출력
res = 0
for i in range(4):
    if t[i][0] == 1:
        res += pow(2, i)
    
print(res)
