import sys
input = lambda : sys.stdin.readline().rstrip()

dx, dy = [0,1,0,-1], [1,0,-1,0]

def cnt(sx, sy, ex, ey):
    tmp = 0
    if ex > N or ey > N:
        return 0
    for x, y in fish:
        if sx <= x < ex and sy <= y < ey:
            tmp += 1
    return tmp


def move(sx, sy, Lx, Ly):
    global answer
    Lx_move, Ly_move = Lx, Ly
    for Lx_move in range(Lx+1):
        for Ly_move in range(Ly+1):
            sx += Lx_move
            sy += Ly_move
            
            if sx >= 0 and sy >= 0:
                ex = sx+Lx+1
                ey = sy+Ly+1
                if ex <= N and ey <= N:
                    answer = max(answer, cnt(sx, sy, ex, ey))
            
            sx -= Lx_move
            sy -= Ly_move


def solve():
    for fx, fy in fish:
        for Lx in range(1, L//2):
            Ly = L//2 - Lx
            move(fx-Lx, fy-Ly, Lx, Ly)


N, L, M = map(int, input().split())
fish = [list(map(lambda t: int(t)-1, input().split())) for _ in range(M)]
answer = 0

solve()

print(answer)
