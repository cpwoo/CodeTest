import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

loc = [-1]*1_000_001
cnt = [0]*n

for idx, a in enumerate(arr):
    loc[a] = idx

for idx, a in enumerate(arr):
    for i in range(a, 1_000_001, a):
        if loc[i] != -1:
            cnt[loc[i]] -= 1
            cnt[idx] += 1

print(*cnt)
