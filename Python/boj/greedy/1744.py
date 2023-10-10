import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())

answer = 0
positive = []
negative = []

for _ in range(n):
    x = int(input())

    if x > 1:
        positive.append(x)
    elif x == 1:
        answer += 1
    else:
        negative.append(x)

positive.sort(reverse=True)
negative.sort()

for i in range(0, len(positive)-1, 2):
    answer += positive[i] * positive[i+1]

if len(positive)%2 == 1:
    answer += positive[-1]

for i in range(0, len(negative)-1, 2):
    answer += negative[i] * negative[i+1]

if len(negative)%2 == 1:
    answer += negative[-1]

print(answer)
