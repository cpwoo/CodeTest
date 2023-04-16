def solution(commands):
    answer = []
    merged = [[[i, j] for j in range(51)] for i in range(51)]
    content = [["EMPTY"]*51 for _ in range(51)]
    
    for command in commands:
        command = command.split()
        
        if command[0] == "UPDATE":
            if len(command) == 4:
                r, c, value = command[1:]
                r, c = map(int, [r, c])
                x, y = merged[r][c]
                content[x][y] = value
            else:
                value1, value2 = command[1:]
                for i in range(1, 51):
                    for j in range(1, 51):
                        if content[i][j] == value1:
                            content[i][j] = value2
        
        elif command[0] == "MERGE":
            r1, c1, r2, c2 = map(int, command[1:])
            x1, y1 = merged[r1][c1]
            x2, y2 = merged[r2][c2]
            if content[x1][y1] == "EMPTY":
                content[x1][y1] = content[x2][y2]
            for i in range(1, 51):
                for j in range(1, 51):
                    if merged[i][j] == [x2, y2]:
                        merged[i][j] = [x1, y1]

        elif command[0] == "UNMERGE":
            r, c = map(int, command[1:])
            x, y = merged[r][c]
            tmp = content[x][y]
            for i in range(1, 51):
                for j in range(1, 51):
                    if merged[i][j] == [x, y]:
                        merged[i][j] = [i, j]
                        content[i][j] = "EMPTY"
            content[r][c] = tmp
        
        elif command[0] == "PRINT":
            r, c = map(int, command[1:])
            x, y = merged[r][c]
            answer.append(content[x][y])

    return answer


commands = ["UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"]
print(solution(commands)) # ["EMPTY", "group"]

commands = ["UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"]
print(solution(commands)) # ["d", "EMPTY"]
