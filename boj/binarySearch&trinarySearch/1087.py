import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def solve(t):
    posx = sorted([sx+dx*t for sx,dx in X])
    posy = sorted([sy+dy*t for sy,dy in Y])
    return max(posx[-1]-posx[0], posy[-1]-posy[0])


N = int(input())
X, Y = [], []
for _ in range(N):
    sx, sy, dx, dy = map(int, input().split())
    X.append([sx, dx])
    Y.append([sy, dy])

start, end = 0, 2000
for _ in range(500):
    left, right = (start*2+end)/3, (start+end*2)/3
    if solve(left) <= solve(right):
        end = right
    else:
        start = left

print(solve(start))
