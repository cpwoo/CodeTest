import sys
INF = sys.maxsize

from itertools import product

dx, dy = [-1, 1, 0, 0, 0], [0, 0, 0, -1, 1]

def solution(clockHands):
    answer = INF
    n = len(clockHands)
    
    def rotate(y, x, t, table):
        for k in range(5):
            ny, nx = y+dy[k], x+dx[k]
            if (0 <= ny < n) and (0 <= nx < n):
                table[ny][nx] = (table[ny][nx]+t)%4
    
    for f in product(range(4), repeat=n):
        table = [i[:] for i in clockHands]
        for x in range(n):
            rotate(0, x, f[x], table)
        cnt = sum(f)
        
        for y in range(1, n):
            for x in range(n):
                if table[y-1][x]:
                    tmp = 4-table[y-1][x]
                    rotate(y, x, tmp, table)
                    cnt += tmp
        
        if sum(table[n-1]) == 0:
            answer = min(answer, cnt)
                
    return answer


clockHands = [[0,3,3,0],[3,2,2,3],[0,3,2,0],[0,3,3,3]]
print(solution(clockHands)) # 3
