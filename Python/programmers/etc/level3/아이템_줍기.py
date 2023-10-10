from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def solution(rectangle, characterX, characterY, itemX, itemY):
    
    field = [[-1]*102 for _ in range(102)]
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda t: t*2, r)
        for i in range(x1, x2+1):
            for j in range(y1, y2+1):
                if x1 < i < x2 and y1 < j < y2:
                    field[i][j] = 0
                elif field[i][j] != 0:
                    field[i][j] = 1
    
    q = deque()
    q.append([characterX*2, characterY*2])
    visited = [[1]*102 for _ in range(102)]
    
    while q:
        x, y = q.popleft()
        if (x, y) == (itemX*2, itemY*2):
            answer = visited[x][y]//2
            break
        for d in range(4):
            nx, ny = x+dx[d], y+dy[d]
            if field[nx][ny] == 1 and visited[nx][ny] == 1:
                q.append([nx, ny])
                visited[nx][ny] = visited[x][y]+1
                
    return answer


rectangle = [[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]
characterX, characterY, itemX, itemY = 1, 3, 7, 8
print(solution(rectangle, characterX, characterY, itemX, itemY)) # 17

rectangle = [[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]
characterX, characterY, itemX, itemY = 9, 7, 6, 1
print(solution(rectangle, characterX, characterY, itemX, itemY)) # 11

rectangle = [[1,1,5,7]]
characterX, characterY, itemX, itemY = 1, 1, 4, 7
print(solution(rectangle, characterX, characterY, itemX, itemY)) # 9

rectangle = [[2,1,7,5],[6,4,10,10]]
characterX, characterY, itemX, itemY = 3, 1, 7, 10
print(solution(rectangle, characterX, characterY, itemX, itemY)) # 15

rectangle = [[2,2,5,5],[1,3,6,4],[3,1,4,6]]
characterX, characterY, itemX, itemY = 1, 4, 6, 3
print(solution(rectangle, characterX, characterY, itemX, itemY)) # 10
