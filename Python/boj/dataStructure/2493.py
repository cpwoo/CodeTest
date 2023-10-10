import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
lst = list(map(int, input().split()))
s = []
answer = []

for i in range(n):
    while s:
        if s[-1][1] > lst[i]:
            answer.append(s[-1][0]+1)
            break
        else:
            s.pop()
    if not s:
        answer.append(0)
    s.append([i, lst[i]])

print(*answer)
