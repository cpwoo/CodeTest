import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
dice = [list(map(int, input().split())) for _ in range(n)]

def check(dice, ds):
    for i in range(6):
        if ds == dice[i]:
            idx = i
            break
    
    if idx == 0:
        return (max(dice[1], dice[2], dice[3], dice[4]), dice[5])
    elif idx == 5:
        return (max(dice[1], dice[2], dice[3], dice[4]), dice[0])
    elif idx == 1:
        return (max(dice[0], dice[2], dice[5], dice[4]), dice[3])
    elif idx == 3:
        return (max(dice[0], dice[2], dice[5], dice[4]), dice[1])
    elif idx == 2:
        return (max(dice[0], dice[1], dice[5], dice[3]), dice[4])
    elif idx == 4:
        return (max(dice[0], dice[1], dice[5], dice[3]), dice[2])

maximum = 0
for i in range(1, 7):
    nxt_ds = i
    ans = 0
    for t in range(n):
        tmp, nxt_ds = check(dice[t], nxt_ds)
        ans += tmp
    maximum = max(maximum, ans)
print(maximum)
