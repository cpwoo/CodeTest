import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(a, b, c, p1, p2):
    if a < 0 or b < 0 or c < 0: return False
    if ((a,b,c) == (0,0,0)): return True
    if dp[a][b][c][p1][p2]: return False
    dp[a][b][c][p1][p2] = True

    ans[n-a-b-c] = "A"
    if dfs(a-1, b, c, 0, p1): return True

    if p1 != 1:
        ans[n-a-b-c] = "B"
        if dfs(a, b-1, c, 1, p1): return True
    
    if p1 != 2 and p2 != 2:
        ans[n-a-b-c] = "C"
        if dfs(a, b, c-1, 2, p1): return True
    
    return False


st = input()
n = len(st)

# a개수, b개수, c개수, 전날, 전전날
dp = [[[[[False]*3 for _ in range(3)] for _ in range(n+1)] for _ in range(n+1)] for _ in range(n+1)]

ans = [""]*n

an, bn, cn = 0, 0, 0
for s in st:
    if s == "A": an += 1
    elif s == "B": bn += 1
    elif s == "C": cn += 1

print("".join(ans) if dfs(an, bn, cn, 0, 0) else -1)
