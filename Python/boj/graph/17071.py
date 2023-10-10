import sys
input = lambda: sys.stdin.readline().rstrip()

MAX = 500_000

n, k = map(int, input().split())

visited = [[-1]*2 for _ in range(MAX+1)]

if n == k:
    print(0)
    exit()

q = [n]
time = 1
k += time

while True:
    if k > MAX: break

    tmp = []

    for cur in q:
        for nxt in [cur-1, cur+1, cur*2]:
            if 0 <= nxt <= MAX and visited[nxt][time%2] == -1:
                tmp.append(nxt)
                visited[nxt][time%2] = time
    
    if visited[k][time%2] != -1:
        print(time)
        exit()

    time += 1
    k += time
    q = tmp

print(-1)
