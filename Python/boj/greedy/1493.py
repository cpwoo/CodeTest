import sys
input = lambda: sys.stdin.readline().rstrip()

L, W, H = map(int, input().split())
cube = sorted([list(map(int, input().split())) for _ in range(int(input()))], reverse=True)

tot = L*W*H
ans, cur = 0, 0

for w, cnt in cube:
    cur *= 8
    v = pow(2, w)
    _max = (L//v)*(W//v)*(H//v) - cur
    _max = min(cnt, _max)
    ans += _max
    cur += _max

print(ans if cur == tot else -1)
