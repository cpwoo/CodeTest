import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda t: -t[1])

ret = arr[0][1]-arr[0][0]

for i in range(1, n):
    if ret >= arr[i][1]:
        ret = arr[i][1]-arr[i][0]
    else:
        ret -= arr[i][0]
    
print(ret)
