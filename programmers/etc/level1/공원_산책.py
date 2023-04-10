move = {"E":(0,1),"W":(0,-1),"S":(1,0),"N":(-1,0)}

def solution(park, routes):
    x,y,N,M = 0, 0, len(park), len(park[0])
    for i, row in enumerate(park):
        if "S" in row:
            x, y = i, row.find("S")
            break

    for route in routes:
        dx, dy = move[route[0]]
        nx, ny = x,y
        for _ in range(int(route[2])): 
            if 0 <= nx+dx < N and 0 <= ny+dy < M and park[nx+dx][ny+dy] != "X":
                nx,ny = nx+dx, ny+dy
            else:
                nx,ny = x,y
                break
        x,y = nx,ny

    return [x,y]


park = ["SOO","OOO","OOO"]
routes = ["E 2","S 2","W 1"]
print(solution(park, routes)) # [2,1]

park = ["SOO","OXX","OOO"]
routes = ["E 2","S 2","W 1"]
print(solution(park, routes)) # [0,1]

park = ["OSO","OOO","OXO","OOO"]
routes = ["E 2","S 3","W 1"]
print(solution(park, routes)) # [0,0]
