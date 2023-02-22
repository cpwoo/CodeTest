import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
lst = []
s = 0
for _ in range(n):
    x, a = map(int, input().split())
    lst.append([x, a])
    s += a

lst.sort()

cnt, pos = 0, 0

for i in range(n):
    cnt += lst[i][1]
    if cnt >= s/2:
        pos = lst[i][0]
        break
        
print(pos)
