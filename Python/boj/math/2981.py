import sys
input = lambda: sys.stdin.readline().rstrip()

from math import gcd

n = int(input())
paper = sorted([int(input()) for _ in range(n)])

interval = []
for i in range(1, n):
    interval.append(paper[i]-paper[i-1]) 

prev = interval[0]
for i in range(1, len(interval)):
    prev = gcd(prev, interval[i])

answer = []
for i in range(2, int(prev**0.5)+1):
    if prev % i == 0:
        answer.append(i)
        answer.append(prev//i)
answer.append(prev)

answer = sorted(list(set(answer)))
print(*answer)
