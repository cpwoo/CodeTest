import sys
input = lambda: sys.stdin.readline().rstrip()

def recursive(x, y, n):
    if n == 3:
        graph[x][y] = '*'
        graph[x+1][y-1] = graph[x+1][y+1] = '*'
        for i in range(-2, 3):
            graph[x+2][y+i] = '*'
    else:
        recursive(x,y,n//2)
        recursive(x+n//2,y-n//2,n//2)
        recursive(x+n//2,y+n//2,n//2)

n = int(input())
graph = [[' ']*(2*n) for _ in range(n)]

recursive(0, n-1, n)
for i in graph:
    print(''.join(i))
