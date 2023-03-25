import sys
input = lambda: sys.stdin.readline().rstrip()

def left_dfs(idx, cur_sum):
    if idx == n//2:
        dist[cur_sum] = dist.get(cur_sum, 0) + 1
        return 
    
    left_dfs(idx+1, cur_sum)
    left_dfs(idx+1, cur_sum + arr[idx])

def right_dfs(idx, cur_sum):
    global ans

    if idx == n:
        ans += dist.get(s - cur_sum, 0)
        return
    
    right_dfs(idx+1, cur_sum)
    right_dfs(idx+1, cur_sum + arr[idx])


n, s = map(int, input().split())
arr = list(map(int, input().split()))

dist = dict()
ans = 0

left_dfs(0, 0); right_dfs(n//2, 0)

if s == 0: ans -= 1
print(ans)
