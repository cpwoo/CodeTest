import sys
input = lambda: sys.stdin.readline().rstrip()

dx, dy = [0, 0, -1, -1, 1, 1], [-1, 1, -1, 1, -1, 1]

def bipartite_matching(x, y):
    for d in range(6):
        nx, ny = x+dx[d], y+dy[d]
        if (0 <= nx < n) and (0 <= ny < m) and not visited[nx][ny] and check[nx][ny]:
            visited[nx][ny] = True
            p, q = connect[nx][ny]
            if (p, q) == (-1, -1) or bipartite_matching(p, q):
                connect[nx][ny] = [x, y]
                return True
    return False
    

for _ in range(int(input())):
    n, m = map(int, input().split())
    board = [input() for _ in range(n)]
    check = [[False]*m for _ in range(n)]
    
    # . 과 x 를 참 거짓으로 저장할 테이블 만들고 앉을 수 있으면 answer++
    answer = 0
    for x in range(n):
        for y in range(m):
            if board[x][y] == ".":
                check[x][y] = True
                answer += 1
    
    # 각 자리마다 연결 위치(x좌표, y좌표) 저장
    connect = [[[-1]*2 for _ in range(m)] for _ in range(n)]
    # 연결되어있으면 answer--
    for x in range(n):
        for y in range(0, m, 2):
            if check[x][y]:
                visited = [[False]*m for _ in range(n)]
                if bipartite_matching(x, y):
                    answer -= 1

    print(answer)
