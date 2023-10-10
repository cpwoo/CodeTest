def solution(beginning, target):
    m, n = len(beginning), len(beginning[0])
    table = [[beginning[i][j]^target[i][j] for j in range(n)] for i in range(m)]
    
    cnt = 0
    for i in range(1, m):
        if table[i] != table[0]:
            cnt += 1
            if (list(map(lambda x: x^1, table[i])) != table[0]):
                return -1

    return min(cnt+sum(table[0]), (m-cnt)+(n-sum(table[0])))


beginning = [[0, 1, 0, 0, 0], [1, 0, 1, 0, 1], [0, 1, 1, 1, 0], [1, 0, 1, 1, 0], [0, 1, 0, 1, 0]]
target = [[0, 0, 0, 1, 1], [0, 0, 0, 0, 1], [0, 0, 1, 0, 1], [0, 0, 0, 1, 0], [0, 0, 0, 0, 1]]
print(solution(beginning, target)) # 5

beginning = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
target = [[1, 0, 1], [0, 0, 0], [0, 0, 0]]
print(solution(beginning, target)) # -1
