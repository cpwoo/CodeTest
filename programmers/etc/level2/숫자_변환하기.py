from collections import deque

def solution(x, y, n):
    q = deque([x])
    visited = [-1]*(y+1)
    visited[x] = 0
    while q:
        cur = q.popleft()
        for nxt in [cur+n, cur*2, cur*3]:
            if nxt <= y and visited[nxt] == -1:
                visited[nxt] = visited[cur]+1
                q.append(nxt)
    return visited[y]


x, y, n = 10, 40, 5
print(solution(x, y, n)) # 2

x, y, n = 10, 40, 30
print(solution(x, y, n)) # 1

x, y, n = 2, 5, 4
print(solution(x, y, n)) # -1
