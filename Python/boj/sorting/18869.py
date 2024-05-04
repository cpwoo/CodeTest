import sys
input = lambda: sys.stdin.readline().rstrip()

m, n = map(int, input().split())
arr = []

for _ in range(m):
    tmp = list(map(int, input().split()))

    sorted_tmp = sorted(tmp)
    d = {}
    for i, s in enumerate(sorted_tmp):
        d[s] = i
    
    comp = []
    for t in tmp:
        comp.append(d[t])
    arr.append(comp)

cnt = 0
for i in range(m-1):
    for j in range(i+1, m):
        flag = True
        for k in range(n):
            if arr[i][k] != arr[j][k]:
                flag = False
                break
        cnt += 1 if flag else 0

print(cnt)
