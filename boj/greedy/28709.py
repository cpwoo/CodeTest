import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(st):
    _min, _max = 0, 0
    flag = False
    for s in st:
        if s == "(":
            _min += 1
            _max += 1
        elif s == ")":
            if _max == 0:
                return "NO"
            _min = max(_min-1, 0)
            _max -= 1
        elif s == "?":
            _min = max(_min-1, 0)
            _max += 1
        elif s == "*":
            _min = 0
            _max = 500001
            flag = True
    return "NO" if (not flag and (_max-_min)&1) or _min != 0 else "YES"

for _ in range(int(input())):
    print(solve(input()))
