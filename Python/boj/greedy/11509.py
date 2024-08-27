import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

res = [0]*1000001

for i in arr:
    if res[i] > 0:
        res[i] -= 1
        res[i-1] += 1
    else:
        res[i-1] += 1

print(sum(res))
