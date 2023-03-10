import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
check = [True]*(n+1)
check[0] = check[1] = False
prime = []

for i in range(2, n+1):
    if check[i]:
        prime.append(i)
        for j in range(2*i, n+1, i):
            check[j] = False

answer = 0
start, end = 0, 0

while end <= len(prime):
    tmp = sum(prime[start:end])
    if tmp == n:
        answer += 1
        end += 1
    elif tmp < n:
        end += 1
    else:
        start += 1

print(answer)
