direc = [[-1,0],[1,0],[0,-1],[0,1]]

def solution(maze):
    def cand(cur, e, visited):
        x, y = cur
        answer = []

        if cur == e:
            return [e]
        
        for dx, dy in direc:
            if (0 <= x+dx < len(maze)) and (0 <= y+dy < len(maze[0])) and (x+dx, y+dy) not in visited:
                if maze[x+dx][y+dy] != 5:
                    answer.append((x+dx, y+dy))

        return answer


    def search(r, b, turn, r_visited, b_visited):
        nonlocal _min

        if (r, b) == (er, eb):
            _min[0] = min(_min[0], turn)
            return
        
        red_can = cand(r, er, r_visited)
        blue_can = cand(b, eb, b_visited)

        for rc in red_can:
            for bc in blue_can:
                if rc != bc and (rc, bc) != (b, r):
                    nr_visited = r_visited | {rc}
                    nb_visited = b_visited | {bc}
                    search(rc, bc, turn+1, nr_visited, nb_visited)


    for i in range(len(maze)):
        for j in range(len(maze[0])):
            if maze[i][j] == 1:
                r = (i, j)
            elif maze[i][j] == 2:
                b = (i, j)
            elif maze[i][j] == 3:
                er = (i, j)
            elif maze[i][j] == 4:
                eb = (i, j)

    _min = [1000]
    r_visited, b_visited = {r}, {b}
    search(r, b, 0, r_visited, b_visited)
    
    return _min[0] if _min[0] != 1000 else 0
