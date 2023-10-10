import sys
input = lambda: sys.stdin.readline().rstrip()

# Kx+1=Cy, Cy-Kx=1, 확장 유클리드 호제법 이용! a=C, b=K, g=1
# gcd(C, K) = 1 을 만족해야 한다. 단, y가 1e9 를 넘어가면 안 된다.(문제 조건)

def exteneded_gcd(a, b):
    x0, x1, y0, y1 = 1, 0, 0, 1
    while b != 0:
        n, a, b = a//b, b, a%b
        x0, x1 = x1, x0-n*x1
        y0, y1 = y1, y0-n*y1
    return x0, x1, y0, y1


for _ in range(int(input())):
    k, c = map(int, input().split())
    x0, x1, y0, y1 = exteneded_gcd(c, k)
    if c == 1:
        print("IMPOSSIBLE" if k >= int(1e9) else k+1)
    elif x1 != -k and y1 != -c:
        print("IMPOSSIBLE")
    else:
        ans = x0 if x0>0 else x0+x1
        print("IMPOSSIBLE" if ans > int(1e9) else ans)
