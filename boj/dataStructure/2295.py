import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted([int(input()) for _ in range(n)])

can = set()
for i in arr:
    for j in arr:
        can.add(i+j)

answer = {}
for i in arr:
    for j in arr:
        if i-j in can:
            answer[i] = (i, j, i-j)

print(sorted(list(answer.keys()))[-1])
