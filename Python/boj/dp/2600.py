import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(p, q):
    if dp[p][q] >= 0: return dp[p][q]

    for i in range(3):
        if b[i] <= p and not solve(p-b[i], q):
            dp[p][q] = 1
            return dp[p][q]
    
    for i in range(3):
        if b[i] <= q and not solve(p, q-b[i]):
            dp[p][q] = 1
            return dp[p][q]
    
    dp[p][q] = 0
    
    return dp[p][q]


b = list(map(int, input().split()))
dp = [[-1]*501 for _ in range(501)]

for _ in range(5):
    k1, k2 = map(int, input().split())
    print("A" if solve(k1, k2) else "B")
