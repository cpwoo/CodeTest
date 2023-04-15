import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def dfs(door1, door2, depth, cnt):
    global ans
    
    if depth == m:
        ans = min(ans, cnt)
        return
    
    tmp1 = abs(door1-arr[depth])
    tmp2 = abs(door2-arr[depth])

    dfs(arr[depth], door2, depth+1, cnt+tmp1)
    dfs(door1, arr[depth], depth+1, cnt+tmp2)


ans = INF
n = int(input())
door1, door2 = map(int, input().split())
m = int(input())
arr = [int(input()) for _ in range(m)]

dfs(door1, door2, 0, 0)
print(ans)
