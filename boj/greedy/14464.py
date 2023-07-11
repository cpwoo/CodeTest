import sys
input = lambda: sys.stdin.readline().rstrip()

C, N = map(int, input().split())
chicken = sorted([int(input()) for _ in range(C)])
cow = sorted([list(map(int, input().split())) for _ in range(N)], key=lambda x: x[1])

visited = [0]*C

ans = 0
for s, e in cow:
    for idx, value in enumerate(chicken):
        if s <= value <= e and not visited[idx]:
            ans += 1
            visited[idx] = 1
            break

print(ans)
