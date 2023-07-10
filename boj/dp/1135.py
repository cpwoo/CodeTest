import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(cur):
    child = []
    for nxt in tree[cur]:
        dfs(nxt)
        child.append(dp[nxt])
    if child:
        child.sort(reverse=True)
        dp[cur] = max([child[i]+i+1 for i in range(len(child))])


n = int(input())
parent = list(map(int, input().split()))

tree = [[] for _ in range(n)]
for u, v in enumerate(parent):
    if v != -1:
        tree[v].append(u)

dp = [0]*n
dfs(0)
print(dp[0])
