import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [-1, 1, 0, 0], [0, 0, 1, -1]

def moving():
    g = [[[] for _ in range(c)] for _ in range(r)]
    for i in range(r):
        for j in range(c):
            if graph[i][j]:
                x, y = i, j
                z, s, d = graph[i][j][0]
                s_count = s
                while s_count > 0:
                    nx, ny = x+dx[d], y+dy[d]
                    if not (0 <= nx < r and 0 <= ny < c):
                        if d in [0, 2]:
                            d += 1
                        elif d in [1, 3]:
                            d -= 1
                        continue
                    else:
                        x, y = nx, ny
                        s_count -= 1
                g[x][y].append([z, s, d])
    for i in range(r):
        for j in range(c):
            graph[i][j] = g[i][j]


r, c, m = map(int, input().split())

graph = [[[] for _ in range(c)] for _ in range(r)]

for _ in range(m):
    x, y, s, d, z = map(int, input().split())
    graph[x-1][y-1].append([z, s, d-1])

eat_count = 0

for i in range(c):
    for j in range(r):
        if graph[j][i]:
            value = graph[j][i][0]
            eat_count += value[0]
            graph[j][i].remove(value)
            break

    moving()

    for p in range(r):
        for q in range(c):
            if len(graph[p][q]) >= 2:
                graph[p][q].sort(reverse=True)
                while len(graph[p][q]) >= 2:
                    graph[p][q].pop()
print(eat_count)
