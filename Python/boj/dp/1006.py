import sys
input = lambda: sys.stdin.readline().rstrip()

def recur(start, a, b, c):
    for i in range(start, n):
        a[i+1] = min(b[i]+1, c[i]+1)
        if up[i]+down[i] <= w:
            a[i+1] = min(a[i+1], a[i]+1)
        if i > 0 and up[i-1]+up[i] <= w and down[i-1]+down[i] <= w:
            a[i+1] = min(a[i+1], a[i-1]+2)
        if i < n-1:
            b[i+1] = a[i+1]+1
            if up[i+1]+up[i] <= w:
                b[i+1] = min(b[i+1], c[i]+1)
            c[i+1] = a[i+1]+1
            if down[i+1]+down[i] <= w:
                c[i+1] = min(c[i+1], b[i]+1)
    
    return a, b, c


for _ in range(int(input())):
    n, w = map(int, input().split())
    up = list(map(int, input().split()))
    down = list(map(int, input().split()))

    # 1,2행 모두 i-1 열까지 채울 때,
    # 1행 i열과 2행 i-1열 채울 때,
    # 1행 i-1열과 2행 i열 채울 때
    # 각 경우의 최소 소대 수 저장
    a, b, c = [0]*(n+1), [0]*(n+1), [0]*(n+1)
    a[0], b[0], c[0] = 0, 1, 1
    a, b, c = recur(0, a, b, c)
    res = a[n]

    # 1열은 아래와 같이 예외처리 한다.
    if n > 1 and up[0]+up[n-1] <= w:
        a[1], b[1] = 1, 2
        if down[0]+down[1] <= w:
            c[1] = 1
        else:
            c[1] = 2    
        a, b, c = recur(1, a, b, c)
        res = min(res, c[n-1]+1)
    
    if n > 1 and down[0]+down[n-1] <= w:
        a[1], c[1] = 1, 2
        if up[0]+up[1] <= w:
            b[1] = 1
        else:
            b[1] = 2
        a, b, c = recur(1, a, b, c)
        res = min(res, b[n-1]+1)
    
    if n > 1 and up[0]+up[n-1] <= w and down[0]+down[n-1] <= w:
        a[1], b[1], c[1] = 0, 1, 1
        a, b, c = recur(1, a, b, c)
        res = min(res, a[n-1]+2)
    
    print(res)
