import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(left, right):
    if left >= right: return 0
    
    ret = dp[left][right]
    if ret != -1: return ret
    
    ret = int(1e9)
    if st[left] == st[right]:
        ret = solve(left+1, right-1)
    else:
        ret = min(ret, solve(left+1, right-1)+1)
    
    ret = min(ret, solve(left+1, right)+1, solve(left, right-1)+1)
    dp[left][right] = ret

    return dp[left][right]


st = list(input())
L = len(st)

dp = [[-1]*L for _ in range(L)]
answer = solve(0, L-1)

for i in range(L-1):
    for j in range(i+1, L):
        st[i], st[j] = st[j], st[i]
        dp = [[-1]*L for _ in range(L)]
        answer = min(answer, solve(0, L-1)+1)
        st[i], st[j] = st[j], st[i]

print(answer)
