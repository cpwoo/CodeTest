import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dy, dx = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs(y, x):
    visited = [[-1]*(w+2) for _ in range(h+2)] # 맵의 외곽을 추가, 열어야 하는 문의 개수
    q = deque()    
    q.append([y, x])
    visited[y][x] = 0
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny, nx = y+dy[i], x+dx[i]
            if (0 <= ny <= h+1) and (0 <= nx <= w+1) and visited[ny][nx] == -1:
                if board[ny][nx] == '.' or board[ny][nx] == '$': # 문을 안열고 진행
                    visited[ny][nx] = visited[y][x]
                    q.appendleft([ny, nx]) # 가장 앞에 삽입 
                elif board[ny][nx] == '#': # 문을 여는 경우
                    visited[ny][nx] = visited[y][x] + 1
                    q.append([ny, nx])
    return visited


for _ in range(int(input())):
    h, w = map(int, input().split())        
    board = [list('.'*(w+2))] # 맨 윗줄 추가
    for i in range(h):
        board.append(list('.'+ input().strip() + '.'))
    board.append(list('.'*(w+2))) # 맨 아랫줄 추가

    prisoner = []
    for i in range(h+2):              
        for j in range(w+2):
            if board[i][j] == '$':
                prisoner.append([i,j])
    
    one = bfs(prisoner[0][0], prisoner[0][1])
    two = bfs(prisoner[1][0], prisoner[1][1])
    helper = bfs(0, 0)
    answer = sys.maxsize

    for i in range(h+2):
        for j in range(w+2):
            if  one[i][j] != -1 and two[i][j] != -1 and helper[i][j] != -1:
                result = one[i][j]+two[i][j]+helper[i][j] # 해당 위치에서 문을 여는 개수
                if board[i][j] == '*': # 벽은 제외
                    continue
                if board[i][j] == '#': # 한명만 열어도 되기 때문에 나머지 사람이 연 갯수인 2를 빼줌
                    result -= 2
                answer = min(answer, result)
    print(answer)
