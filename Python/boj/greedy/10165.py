import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = int(input()), int(input())

info = []
for i in range(m):
    a, b = map(int, input().split())
    if a < b:
        info.append([a, b, i])
        info.append([a+n, b+n, i])
    else:
        info.append([a, b+n, i])

# 처음부터 탐색하되 시작점이 같다면 길이가 긴 것부터 탐색
info.sort(key=lambda t: (t[0], -t[1]))

visited = [False]*m

# sweeping
left, right = 0, 0
for i in range(len(info)):
    s, e, idx = info[i]
    if visited[idx]:
        continue
    # 구간에 포함되면 True
    if left <= s and e <= right:
        visited[idx] = True
        continue
    left, right = s, e

answer = []
for i in range(m):
    if not visited[i]:
        answer.append(i+1)

print(*answer)
