import sys
input = lambda: sys.stdin.readline().rstrip()

from functools import cmp_to_key

def compare(x, y):
    if x+y > y+x:
        return -1
    if x+y < y+x:
        return 1
    return 0


n = int(input())
arr = [input() for _ in range(n)]
end = len("".join(arr))

arr.sort(key=cmp_to_key(compare))

tmp = ""
while len(tmp) != end:
    plus = arr[-1]
    tmp += plus[0]
    arr.pop()
    if len(plus) > 1:
        arr.append(plus[1:])
    arr.sort(key=cmp_to_key(compare))
    if not arr:
        break

print(tmp)
