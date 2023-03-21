import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]

def bfs():
    while q:
        puzzle = q.popleft()
        cnt = visited[puzzle]
        z = puzzle.index('0')

        if puzzle == "123456780":
            return cnt

        x, y = z//3, z%3

        cnt += 1
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if (0 <= nx <= 2) and (0 <= ny <= 2):
                nz = nx*3+ny
                puzzle_list = list(puzzle)
                puzzle_list[z], puzzle_list[nz] = puzzle_list[nz], puzzle_list[z]
                new_puzzle = "".join(puzzle_list)

                if visited.get(new_puzzle, 0) == 0:
                    visited[new_puzzle] = cnt
                    q.append(new_puzzle)
    return -1


puzzle = ""
for i in range(3):
    puzzle += "".join(list(input().split()))

visited = {puzzle:0}
q = deque([puzzle])

print(bfs())
