from collections import deque

dx, dy = [-1,1,0,0], [0,0,-1,1]

def solution(land):
    def bfs(i, j, group):
        q = deque()
        q.append((i, j))
        visited[i][j] = group
        amount = 1
        while q:
            x, y = q.popleft()
            for d in range(4):
                nx, ny = x+dx[d], y+dy[d]
                if (0 <= nx < n) and (0 <= ny < m) and land[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = group
                    amount += 1
        return amount
    
    
    n, m = len(land), len(land[0])
    visited = [[0]*m for _ in range(n)]
    
    group = 0
    cnt = dict()
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and not visited[i][j]:
                group += 1
                cnt[group] = bfs(i, j, group)
    
    answer = 0
    
    for j in range(m):
        s = set()
        for i in range(n):
            if visited[i][j]:
                s.add(visited[i][j])
        
        tmp = 0
        for e in s:
            tmp += cnt[e]
        
        answer = max(answer, tmp)
    
    return answer
