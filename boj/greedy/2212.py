import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = int(input()), int(input())
arr = sorted(list(map(int, input().split())))

if k >= n:
    print(0)
    exit()

d = []
for i in range(1, n):
    d.append(arr[i]-arr[i-1])

d.sort()

while k > 1:
    d.pop()
    k -= 1

print(sum(d))
