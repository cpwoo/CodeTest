import sys
input = lambda: sys.stdin.readline().rstrip()

N, K, S = map(int, input().split())

left, right = [], []
for _ in range(N):
    pos, cnt = map(int, input().split())
    if pos < S:
        left.append([pos, cnt])
    else:
        right.append([pos, cnt])

left.sort()
right.sort(reverse=True)

answer = 0
bus = 0
for l in left:
    bus += l[1]
    while bus > 0:
        bus -= K
        answer += (S-l[0])*2

bus = 0
for r in right:
    bus += r[1]
    while bus > 0:
        bus -= K
        answer += (r[0]-S)*2

print(answer)
