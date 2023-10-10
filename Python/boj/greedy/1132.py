import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
alpha = [[0, False] for _ in range(10)]

ans = 0
for _ in range(n):
    st = list(input())
    m = 1
    alpha[ord(st[0])-ord("A")][1] = True
    for s in range(len(st)-1, -1, -1):
        alpha[ord(st[s])-ord("A")][0] += m
        m *= 10

alpha.sort()

if alpha[0][1]:
    for i in range(1, 10):
        if not alpha[i][1]:
            del alpha[i]
            break

for i in range(1, 10):
    ans += alpha[-i][0]*(10-i)

print(ans)
