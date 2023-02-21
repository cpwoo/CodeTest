import sys
input = lambda: sys.stdin.readline().rstrip()

words = [input() for _ in range(int(input()))]

d = {}

for word in words:
    digit = len(word)-1
    for w in word:
        if w in d:
            d[w] += pow(10, digit)
        else:
            d[w] = pow(10, digit)
        digit -= 1

d = sorted(d.values(), reverse=True)

result = 0
m = 9

for value in d:
    result += value * m
    m -= 1

print(result)
