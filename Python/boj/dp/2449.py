import sys
input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)

def solve(start, end):
    if start == end:
        return 0
    
    ret = dp[start][end]
    if ret != -1:
        return ret
    
    ret = int(1e9)    
    for i in range(start, end):
        tmp = 0 if arr[start] == arr[i+1] else 1
        ret = min(ret, solve(start, i)+solve(i+1, end)+tmp)
    
    return ret


n, k = map(int, input().split())
a = list(map(int, input().split()))

arr = [a[0]]
for i in range(1, n):
    if arr[-1] != a[i]:
        arr.append(a[i])
n = len(arr)

dp = [[-1]*n for _ in range(n)]
print(solve(0, n-1))
