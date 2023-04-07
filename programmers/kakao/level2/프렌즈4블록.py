def solution(m, n, board):
    x = board
    x2 = []

    for i in x: 
        x1 = []
        for i2 in i:
            x1.append(i2)
        x2.append(x1)

    point = 1
    while point != 0:
        lst = []
        point = 0
        for i in range(m-1):
            for j in range(n-1):
                if x2[i][j] == x2[i][j+1] == x2[i+1][j] == x2[i+1][j+1] != ".":
                    lst.append([i, j])
                    point += 1

        for i2 in lst:
            i, j = i2[0], i2[1]
            x2[i][j], x2[i][j+1], x2[i+1][j], x2[i+1][j+1] = ".", ".", ".", "."

        for _ in range(m):
            for i in range(m-1):
                for j in range(n):
                    if x2[i+1][j] == ".":
                        x2[i+1][j], x2[i][j] = x2[i][j], "."

    cnt = 0
    for i in x2:
        cnt += i.count(".")
    
    return cnt


m, n = 4, 5
board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
print(solution(m, n, board)) # 14

m, n = 6, 6
board = ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]
print(solution(m, n, board)) # 15
