import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**5)

dir = [(1, 0), (0, 1), (-1, 0), (0, -1)]

def dfs(x, y):
    ret = 1
    ice[x][y] = 0
    for d in dir:
        nx, ny = x + d[0], y + d[1]
        if 0 <= nx < n and 0 <= ny < n and ice[nx][ny]:
            ret += dfs(nx, ny)
    return ret


n, q = map(int, input().split())
n = 2 ** n
ice = [list(map(int, input().split())) for _ in range(n)]

for L in list(map(int, input().split())):
    k = 2 ** L
    for x in range(0, n, k):
        for y in range(0, n, k):
            tmp = [ice[i][y:y+k] for i in range(x, x+k)]
            for i in range(k):
                for j in range(k):
                    ice[x+j][y+k-1-i] = tmp[i][j]


    cnt = [[0]*n for _ in range(n)]
    for x in range(0, n):
        for y in range(0, n):
            for d in dir:
                nx, ny = x + d[0], y + d[1]
                if 0 <= nx < n and 0 <= ny < n and ice[nx][ny]:
                    cnt[x][y] += 1

    for x in range(0, n):
        for y in range(0, n):
            if ice[x][y] > 0 and cnt[x][y] < 3:
                ice[x][y] -= 1

print(sum(sum(i) for i in ice))

ans = 0
for x in range(n):
    for y in range(n):
        if ice[x][y] > 0:
            ans = max(ans, dfs(x, y))
print(ans)
