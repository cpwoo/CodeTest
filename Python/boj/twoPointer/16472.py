import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

n = int(input())
st = input()
d = defaultdict(int)

ans = 1
d[st[0]] = 1
left, right = 0, 0

while left <= right < len(st):
    L = len(d.keys())
    if L <= n:
        ans = max(ans, right-left+1)
        right += 1
        if right < len(st):
            d[st[right]] += 1
    elif L > n:
        d[st[left]] -= 1
        if d[st[left]] == 0:
            del d[st[left]]
        left += 1

print(ans)
