import sys
input = lambda : sys.stdin.readline().rstrip()

from collections import defaultdict, deque

n, k = map(int, input().split())
arr = "".join(list(input().split()))
target = "".join(sorted(arr))

visited = defaultdict(bool)

q = deque()
q.append((arr, 0))

while q:
    cur, cnt = q.popleft()
    if cur == target:
        print(cnt)
        break

    if not visited[cur]:
        visited[cur] = True
        for i in range(n-k+1):
            tmp = cur[i:i+k]
            q.append((cur[:i]+tmp[::-1]+cur[i+k:], cnt+1))
else:
    print(-1)
