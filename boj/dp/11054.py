import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
li = list(map(int, input().split()))
a = [1]*n
b = [1]*n
result = [0]*n

for i in range(n):
    for j in range(i):
        if li[i] > li[j] and a[i] < a[j] + 1:
            a[i] = a[j] + 1
            
for i in range(n-1, -1, -1):
    for j in range(i+1, n):
        if li[i] > li[j] and b[i] < b[j] + 1:
            b[i] = b[j] + 1
    result[i] = a[i] + b[i] - 1

print(max(result))
