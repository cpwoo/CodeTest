import sys
input = lambda: sys.stdin.readline().rstrip()

# 0번 행에 더하는 수를 x라 가정
# 0번 행에 더하는 수 + c번 열에 더하는 수 = A[0][c]
# c번 열에 더하는 수 = A[0][c]-x
# r번 행과 0번 열에 더하는 수 = A[r][0]
# r번 행에 더하는 수 = A[r][0]-(A[0][0]-x) = x+(A[r][0]-A[0][0])

# 연산 횟수 최소화 -> 각 행과 열에 더하는 수를 최대한 많이 0으로 만들기
# x를 모든 A[0][c]와 A[0][0]-A[r][0] 중 가장 많은 수로 고르면 된다

from collections import defaultdict

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]

cnt = defaultdict(int)
for i in range(N):
    cnt[A[0][0]-A[i][0]] += 1
for i in range(M):
    cnt[A[0][i]] += 1

mxv, mxc = 0, 0
for v, c in cnt.items():
    if mxc < c:
        mxv, mxc = v, c

R = [mxv+A[i][0]-A[0][0] for i in range(N)]
C = [A[0][i]-mxv for i in range(M)]

for i in range(N):
    for j in range(M):
        if R[i]+C[j] != A[i][j]:
            print(-1)
            exit()

print(N+M-mxc)
for i in range(N):
    if R[i]:
        print(1, i+1, R[i])
for i in range(M):
    if C[i]:
        print(2, i+1, C[i])
