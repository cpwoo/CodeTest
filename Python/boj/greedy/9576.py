import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(m)]
    arr.sort(key=lambda t: t[1])

    cnt = 0
    visited = [False]*(n+1)
    for a, b in arr:
        for i in range(a, b+1):
            if not visited[i]:
                visited[i] = True
                cnt += 1
                break
    print(cnt)
