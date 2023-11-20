d = {0:(-1,0), 1:(-1,1), 2:(0,1), 3:(1,1), 4:(1,0), 5:(1,-1), 6:(0,-1), 7:(-1,-1)}

def solution(arrows):
    x = (0, 0)
    v = set({x})
    e = set()

    for arrow in arrows:
        for _ in range(2):
            y = (x[0]+d[arrow][0], x[1]+d[arrow][1])
            v.add(y)
            e.add((x[0]+y[0], x[1]+y[1]))
            x = y
        
    return 1-len(v)+len(e)

arrows = [6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]
print(solution(arrows)) # 3
