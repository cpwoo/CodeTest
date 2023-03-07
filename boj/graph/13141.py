import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

n, m = map(int, input().split())
d = [[INF]*(n+1) for _ in range(n+1)]
a = [[0]*(n+1) for _ in range(n+1)]

for i in range(1, n+1):
    d[i][i] = 0

for _ in range(m):
    s, e, l = map(int, input().split())
    d[s][e] = min(d[s][e], l)
    d[e][s] = d[s][e]

    a[s][e] = max(a[s][e], l)
    a[e][s] = a[s][e]

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            d[i][j] = min(d[i][j], d[i][k]+d[k][j])

ret = INF
for s in range(1, n+1):
    cand = 0
    for m in range(1, n+1):
        for e in range(1, n+1):
            if d[m][e] == INF: continue

            tmp = a[m][e]-(d[s][e]-d[s][m])

            if tmp>0: cand = max(cand, tmp/2+d[s][e])
    
    ret = min(ret, cand)

print(ret)
