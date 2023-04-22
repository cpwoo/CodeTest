def solution(wallpaper):
    lux, rdx, luy, rdy = 50, 0, 50, 0
    r, c = len(wallpaper), len(wallpaper[0])
    
    for i in range(r):
        for j in range(c):
            if wallpaper[i][j] == "#":
                lux = min(lux, i)
                rdx = max(rdx, i+1)
                luy = min(luy, j)
                rdy = max(rdy, j+1)
                
    return [lux, luy, rdx, rdy]


wallpaper = [".#...", "..#..", "...#."]
print(solution(wallpaper)) # [0, 1, 3, 4]

wallpaper = ["..........", ".....#....", "......##..", "...##.....", "....#....."]
print(solution(wallpaper)) # [1, 3, 5, 8]

wallpaper = [".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]
print(solution(wallpaper)) # [0, 0, 7, 9]

wallpaper = ["..", "#."]
print(solution(wallpaper)) # [1, 0, 2, 1]
