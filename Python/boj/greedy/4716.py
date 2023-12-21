import sys
input = lambda: sys.stdin.readline().rstrip()

while True:
    n, a, b = map(int, input().split())

    if (n, a, b) == (0, 0, 0):
        break

    arr = [list(map(int, input().split())) for _ in range(n)]
    # A와 B의 거리 차가 큰 순서대로 배치
    arr.sort(key=lambda t: -abs(t[1]-t[2]))

    answer = 0
    for k, da, db in arr:
        if da <= db:
            tmp = min(k,a)
        else:
            tmp = k-min(k,b)
        answer += tmp*da + (k-tmp)*db

        a -= tmp
        b -= k-tmp

    print(answer)
