from collections import deque

def bfs(p):
    start = []
    
    for i in range(5):
        for j in range(5):
            if p[i][j] == 'P':
                start.append([i, j])
    
    for s in start:
        q = deque([s])
        visited = [[0]*5 for _ in range(5)]
        distance = [[0]*5 for _ in range(5)]
        visited[s[0]][s[1]] = 1

        while q:
            x, y = q.popleft()
        
            dx = [-1, 1, 0, 0]
            dy = [0, 0, -1, 1]
        
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
            
                if (0 <= nx < 5) and (0 <= ny < 5) and not visited[nx][ny]:
                    if p[nx][ny] == 'O':
                        q.append([nx, ny])
                        visited[nx][ny] = 1
                        distance[nx][ny] = distance[x][y] + 1
                
                    if p[nx][ny] == 'P' and distance[x][y] <= 1:
                        return 0
    return 1

def solution(places):
    answer = []
    for place in places:
        answer.append(bfs(place))
    return answer


places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(places)) # [1, 0, 1, 1, 1]
