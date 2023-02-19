import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
data = list(range(n+1))

for i in range(7, n+1):
    data[i] = max(data[i-3]*2, data[i-4]*3, data[i-5]*4) # 복붙 개수 1, 2, 3

print(data[n])
