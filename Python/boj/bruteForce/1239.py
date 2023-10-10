import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import permutations

def check(lst):
    line = []
    c = 0
    tmp = 0
    for i in lst:
        c += i
        line.append(c)
    for i in range(0, len(line)-1):
        for t in range(i+1, len(line)):
            if line[i] + 50 == line[t]:
                tmp += 1
    return tmp

ans = 0
n = int(input())
s = sorted(list(map(int, input().split())))

if max(s) > 50:
    print(0)
else:
    brt = list(permutations(s))
    for i in brt:
        tmp = check(list(i))
        ans = max(ans, tmp)
    print(ans)
