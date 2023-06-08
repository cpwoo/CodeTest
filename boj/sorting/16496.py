import sys
input = lambda: sys.stdin.readline().rstrip()

from functools import cmp_to_key

def compare(x, y):
    return 1 if int(x+y) < int(y+x) else -1

n = int(input())
arr = sorted(list(input().split()), key=cmp_to_key(compare))
print(int("".join(arr)))
