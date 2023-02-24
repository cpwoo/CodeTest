import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def move(now):
    answer = []
    tmp = now
    for _ in range(visited[now]+1):
        answer.append(tmp)
        tmp = check[tmp]
    return answer


N, K = map(int, input().split())
visited = [0]*100001
check = [0]*100001

q = deque()
q.append(N)

while q:
    now = q.popleft()
    if now == K:
        print(visited[now])
        answer = move(now)[::-1]
        print(*answer)
        break
    for nxt in (now-1, now+1, 2*now):
        if 0 <= nxt < 100001 and visited[nxt] == 0:
            visited[nxt] = visited[now] + 1
            q.append(nxt)
            check[nxt] = now
