import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import permutations
from copy import deepcopy

N, M, K = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]
rcs = [list(map(int, input().split())) for _ in range(K)]

ans = int(1e9)

for p in permutations(rcs, K):
    copy_A = deepcopy(A)
    for r, c, s in p:
        r -= 1
        c -= 1
        for n in range(s, 0, -1): # 바깥부터 회전
            tmp = copy_A[r-n][c+n]
            copy_A[r-n][c-n+1:c+n+1] = copy_A[r-n][c-n:c+n] # 우
            
            for row in range(r-n, r+n):
                copy_A[row][c-n] = copy_A[row+1][c-n] # 상
            
            copy_A[r+n][c-n:c+n] = copy_A[r+n][c-n+1:c+n+1] # 좌

            for row in range(r+n, r-n, -1):
                copy_A[row][c+n] = copy_A[row-1][c+n] # 하
            copy_A[r-n+1][c+n] = tmp

    for row in copy_A:
        ans = min(ans, sum(row))

print(ans)
