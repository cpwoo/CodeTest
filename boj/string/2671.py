import sys
input = lambda: sys.stdin.readline().rstrip()

import re

s = input()
r = re.compile('(100+1+|01)+')
m = r.fullmatch(s)

print("SUBMARINE" if m else "NOISE")
