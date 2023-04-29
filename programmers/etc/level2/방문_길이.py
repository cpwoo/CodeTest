direc = {"U":(-1,0),"D":(1,0),"L":(0,-1),"R":(0,1)}

def solution(dirs):
    x, y = 0, 0
    s = set()
    
    for d in dirs:
        dx, dy = direc[d]
        nx, ny = x+dx, y+dy
        if -5 <= nx <= 5 and -5 <= ny <= 5:
            s.add((x, y, nx, ny))
            s.add((nx, ny, x, y))
            x, y = nx, ny
    
    return len(s)//2


dirs = "ULURRDLLU"
print(solution(dirs)) # 7

dirs = "LULLLLLLU"
print(solution(dirs)) # 7
