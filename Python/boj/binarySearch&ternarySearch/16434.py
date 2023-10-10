import sys
input = lambda: sys.stdin.readline().rstrip()

from math import ceil

def solve(curATK, maxHP):
    curHP = maxHP
    for type, atk, hp in arr:
        if type == 1:
            turn = ceil(hp/curATK)
            curHP -= atk*(turn-1)
        else:
            curATK += atk
            curHP = curHP+hp if curHP+hp <= maxHP else maxHP
        if curHP <= 0:
            return False
    return True

n, a = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

start, end = 0, n*(1_000_000)*(1_000_000)
while start+1 < end:
    mid = (start+end)//2
    if solve(a, mid):
        end = mid
    else:
        start = mid

print(end)
