import sys
input = lambda: sys.stdin.readline().rstrip()

a, b = input(), input()
A = len(a)

# error case 방지 위해 중간에 "1" 삽입
s = a+"1"+b
n = len(s)

suffix = list(range(n))
g = [ord(s[i]) for i in range(n)] + [-1] # 순위

ng = [0]*(n+1) # 순위 갱신용
ng[suffix[0]], ng[n] = 0, -1

t = 1
while t < n:
    suffix.sort(key=lambda x: (g[x], g[min(x+t, n)]))

    for i in range(1, n):
        p, q = suffix[i-1], suffix[i]

        if g[p] != g[q] or g[min(p+t, n)] != g[min(q+t, n)]:
            ng[q] = ng[p]+1
        else:
            ng[q] = ng[p]
    
    # 정렬되었으면 break
    if ng[n-1] == n-1:
        break

    t <<= 1
    g = ng[:]


LCP = [0]*n
L = 0
for i in range(n):
    k = g[i]
    if k == 0: # 처음은 제외
        continue
    p = suffix[k-1]

    while i+L < n and p+L < n and s[i+L] == s[p+L]:
        L += 1
    LCP[k] = L

    if L:
        L -= 1


# 나누어진 영역에서 max 구하기
m = [0, 0]
for i, j in enumerate(LCP):
    if 0 <= suffix[i-1]+j-1 < A and A < suffix[i]+j-1 < n:
        m = max(m, [j, i])
    if 0 <= suffix[i]+j-1 < A and A < suffix[i-1]+j-1 < n:
        m = max(m, [j, i])

L, start = m
print(L)
print(s[suffix[start]:suffix[start]+L])
