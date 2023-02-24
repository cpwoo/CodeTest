import sys
input = lambda: sys.stdin.readline().rstrip()

from bisect import bisect_left

M, N, L = map(int, input().split())
shoot = sorted(list(map(int, input().split())))

cnt = 0
for _ in range(N):
    x, y = map(int, input().split())
    if y <= L:
        idx = bisect_left(shoot, x)
        for k in [idx-1, idx, idx+1]:
            if k < 0 or k >= M:
                continue
            if abs(shoot[k]-x)+y <= L:
                cnt += 1
                break

print(cnt)
