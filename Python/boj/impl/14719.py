import sys
input = lambda: sys.stdin.readline().rstrip()

h, w = map(int, input().split())
block = list(map(int, input().split()))
answer = 0

for i in range(1, w-1):
    left, right = max(block[:i]), max(block[i+1:])
    compare = min(left, right)
    if block[i] < compare:
        answer += compare - block[i]

print(answer)
