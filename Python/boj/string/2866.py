import sys
input = lambda: sys.stdin.readline().rstrip()

R, C = map(int, input().split())
arr = [list(input()) for _ in range(R)]

chk = [""]*C
for i in range(R-1, -1, -1):
    for j in range(C):
        chk[j] += arr[i][j]
    if len(set(chk)) == C:
        print(i)
        break
else:
    print(0)
