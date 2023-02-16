import sys
input = lambda: sys.stdin.readline().rstrip()

import re

for _ in range(int(input())):
    s = input()
    p = re.compile('(100+1+|01)+')
    m = p.fullmatch(s)
    print('YES' if m else 'NO')
