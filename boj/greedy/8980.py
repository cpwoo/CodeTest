import sys
input = lambda: sys.stdin.readline().rstrip()

n, c = map(int, input().split())
m = int(input())
box = [list(map(int, input().split())) for _ in range(m)]

box.sort(key=lambda t: t[1])

ans = 0
remain = [c]*(n+1)

for i in range(m):
    tmp = c
    for j in range(box[i][0], box[i][1]):
        tmp = min(tmp, remain[j])
    tmp = min(tmp, box[i][2])
    for j in range(box[i][0], box[i][1]):
        remain[j] -= tmp
    ans += tmp
    
print(ans)
