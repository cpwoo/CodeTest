import sys
input = lambda : sys.stdin.readline().rstrip()

N, M, L, K = map(int, input().split())
star = [list(map(int, input().split())) for _ in range(K)]

ret = 0
for i in range(K):
    for j in range(K):
        cnt = 0
        for k in range(K):
            if (star[i][0] <= star[k][0] <= star[i][0]+L) and (star[j][1] <= star[k][1] <= star[j][1]+L):
                cnt += 1
        ret = max(ret, cnt)

print(K-ret)
