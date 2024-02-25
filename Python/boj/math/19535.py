import sys
input = lambda : sys.stdin.readline().rstrip()

n = int(input())
nodes = [list(map(int, input().split())) for _ in range(n-1)]
degree = [0]*(n+1)

for u, v in nodes:
    degree[u] += 1
    degree[v] += 1

D, G = 0, 0

for u, v in nodes:
    D += (degree[u]-1)*(degree[v]-1)

for i in range(1, n+1):
    G += degree[i]*(degree[i]-1)*(degree[i]-2)//6 if degree[i] >= 3 else 0

if D > 3*G:
    print("D")
elif D < 3*G:
    print("G")
else:
    print("DUDUDUNGA")
