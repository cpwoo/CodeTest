import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations

n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]
result = 999999
house, chicken = [], []

for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            house.append((i, j))
        if city[i][j] == 2:
            chicken.append((i, j))

for c in combinations(chicken, m):
    tmp = 0
    for h in house:
        distance = 999
        for j in range(m):
            distance = min(distance, abs(h[0]-c[j][0])+abs(h[1]-c[j][1]))
        tmp += distance
    result = min(result, tmp)

print(result)
