import sys
input = lambda: sys.stdin.readline().rstrip()

# 분할정복
def solve(N, X):
    if X == 1: return 0
    
    if X < hb[N-1]+1: return solve(N-1, X-1)

    if X == hb[N-1]+1: return p[N-1]

    if X == hb[N-1]+2: return p[N-1]+1

    if X < 2*hb[N-1]+2: return p[N-1]+1+solve(N-1, X-(hb[N-1]+2))

    return p[N]


n, x = map(int, input().split())

hb = [0]*(n+1)
p = [0]*(n+1)

hb[0] = 1
p[0] = 1

for i in range(1, n+1):
    hb[i] = 1+hb[i-1]+1+hb[i-1]+1
    p[i] = p[i-1]+1+p[i-1]

print(solve(n, x))
