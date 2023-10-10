import sys
input = lambda: sys.stdin.readline().rstrip()

d, p, q = map(int, input().split())
if p > q: p, q = q, p

if d%p == 0 or d%q == 0:
    print(d)
    exit()

ans = (d//q)*q+q

t = ans
for i in range(1, t//q+1):
    tmp = t-q*i
    if (d-tmp)%p == 0:
        print(d)
        exit()
    else:
        tmp += ((d-tmp)//p)*p+p
    if ans == tmp:
        break
    ans = min(ans, tmp)

print(ans)
