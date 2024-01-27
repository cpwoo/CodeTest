import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n = int(input())
    points = [[0, 0]]
    
    d = dict()
    for _ in range(n):
        x, y = map(int, input().split())
        if x not in d:
            d[x] = list()
        d[x].append(y)
    d = sorted(d.items())

    for i in range(len(d)):
        d[i][1].sort()
        if points[-1][1] != d[i][1][0]:
            d[i][1].sort(reverse=True)
        for j in range(len(d[i][1])):
            points.append([d[i][0], d[i][1][j]])

    m, *arr = map(int, input().split())

    for i in range(m):
        print(*points[arr[i]])
