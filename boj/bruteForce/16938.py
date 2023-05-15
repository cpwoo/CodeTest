import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations

N, L, R, X = map(int, input().split())
arr = sorted(list(map(int, input().split())))
cnt = 0
for i in range(2, N+1):
    for comb in combinations(arr, i):
        if L <= sum(comb) <= R:
            if comb[-1]-comb[0] >= X:
                cnt += 1
print(cnt)
