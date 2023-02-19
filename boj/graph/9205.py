import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs():
    q = deque()
    q.append([home[0], home[1]])
    while q:
        x, y = q.popleft()
        if abs(x-fest[0]) + abs(y-fest[1]) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                nx, ny = conv[i]
                if abs(x-nx) + abs(y-ny) <= 1000:
                    q.append([nx, ny])
                    visited[i] = 1
    print("sad")
    return


for _ in range(int(input())):
    n = int(input())
    home = list(map(int, input().split()))
    conv = [list(map(int, input().split())) for _ in range(n)]
    fest = list(map(int, input().split()))
    visited = [0]*(n+1)
    bfs()
