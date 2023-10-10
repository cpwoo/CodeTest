import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
board = [list(input()) for _ in range(n)]
ret = n**2+1

for f in range(1<<n):
    tmp = [board[i][:] for i in range(n)]
    for i in range(n):
        if f & (1<<i):
            for j in range(n):
                if tmp[i][j] == "H":
                    tmp[i][j] = "T"
                else:
                    tmp[i][j] = "H"
    
    tot = 0
    for j in range(n):
        cnt = 0
        for i in range(n):
            if tmp[i][j] == "T":
                cnt += 1
        tot += min(cnt, n-cnt)
    ret = min(ret, tot)

print(ret)
