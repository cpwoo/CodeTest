import sys
input = lambda: sys.stdin.readline().rstrip()

from math import factorial

def combi(idx, x, y, z):
    return factorial(idx)//(factorial(x)*factorial(y)*factorial(z))

def dfs(lv, rn, gn, bn):
    if lv > n: return 1
    
    ret = dp[lv][rn][gn][bn]
    if ret != -1: return ret
    
    ret = 0
    
    if r-rn >= lv: ret += dfs(lv+1, rn+lv, gn, bn)
    if g-gn >= lv: ret += dfs(lv+1, rn, gn+lv, bn)
    if b-bn >= lv: ret += dfs(lv+1, rn, gn, bn+lv)

    if lv%2 == 0:
        if r-rn >= lv//2 and g-gn >= lv//2:
            ret += combi(lv, lv//2, lv//2, 0)*dfs(lv+1, rn+lv//2, gn+lv//2, bn)

        if g-gn >= lv//2 and b-bn >= lv//2:
            ret += combi(lv, 0, lv//2, lv//2)*dfs(lv+1, rn, gn+lv//2, bn+lv//2)

        if r-rn >= lv//2 and b-bn >= lv//2:
            ret += combi(lv, lv//2, 0, lv//2)*dfs(lv+1, rn+lv//2, gn, bn+lv//2)

    if lv%3 == 0:
        if r-rn >= lv//3 and g-gn >= lv//3 and b-bn >= lv//3:
            ret += combi(lv, lv//3, lv//3, lv//3)*dfs(lv+1, rn+lv//3, gn+lv//3, bn+lv//3)

    dp[lv][rn][gn][bn] = ret

    return ret


n, r, g, b = map(int, input().split())
dp = [[[[-1]*(b+1) for _ in range(g+1)] for _ in range(r+1)] for _ in range(n+1)]

print(dfs(1, 0, 0, 0))
