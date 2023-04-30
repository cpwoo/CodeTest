import sys
INF = sys.maxsize

def solution(line):
    meet = []
    n = len(line)
    _minX, _maxX, _minY, _maxY = INF, -INF, INF, -INF
    for i in range(n-1):
        for j in range(i+1, n):
            x1, y1, c1 = line[i]
            x2, y2, c2 = line[j]
            if x1*y2 == y1*x2:
                continue
            x = (y1*c2-c1*y2)/(x1*y2-y1*x2)
            y = (c1*x2-x1*c2)/(x1*y2-y1*x2)
            if (x, y) == (int(x), int(y)):
                x, y = int(x), int(y)
                _minX = min(_minX, x)
                _maxX = max(_maxX, x)
                _minY = min(_minY, y)
                _maxY = max(_maxY, y)
                meet.append([y, x])
    
    board = [["." for _ in range(_maxX-_minX+1)] for _ in range(_maxY-_minY+1)]
    for y, x in meet:
        board[_maxY-y][x-_minX] = "*"
    
    return ["".join(row) for row in board]


line = [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]
print(solution(line)) # ["....*....", ".........", ".........", "*.......*", ".........", ".........", ".........", ".........", "*.......*"]

line = [[0, 1, -1], [1, 0, -1], [1, 0, 1]]
print(solution(line)) # ["*.*"]

line = [[1, -1, 0], [2, -1, 0]]
print(solution(line)) # ["*"]

line = [[1, -1, 0], [2, -1, 0], [4, -1, 0]]
print(solution(line)) # ["*"]
