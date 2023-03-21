import sys
input = lambda: sys.stdin.readline().rstrip()

dy = [-1, 0, 1]

def solve(i, j):
    if j == c-1:
        return True
    
    for d in dy:
        if 0 <= i+d < r and table[i+d][j+1] == '.' and not visited[i+d][j+1]:
            visited[i+d][j+1] = True
            if solve(i+d, j+1):
                return True
    return False

r, c = map(int, input().split())
table = [list(input()) for _ in range(r)]
visited = [[False]*c for _ in range(r)]

ans = 0
for i in range(r):
    if table[i][0] == '.':
        if solve(i, 0):
            ans += 1
print(ans)
