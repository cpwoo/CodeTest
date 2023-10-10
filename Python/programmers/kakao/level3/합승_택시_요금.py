import sys
INF = sys.maxsize

def solution(n, s, a, b, fares):
    matrix = [[INF]*n for _ in range(n)]
    for i in range(n):
        matrix[i][i] = 0

    for f in fares:
        matrix[f[1]-1][f[0]-1] = f[2]
        matrix[f[0]-1][f[1]-1] = f[2]
    
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if matrix[i][k] + matrix[k][j] < matrix[i][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]
    
    return min(matrix[s-1][k] + matrix[k][a-1] + matrix[k][b-1] for k in range(n))


n, s, a, b = 6, 4, 6, 2
fares = [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
print(solution(n, s, a, b, fares)) # 82

n, s, a, b = 7, 3, 4, 1
fares = [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]
print(solution(n, s, a, b, fares)) # 14

n, s, a, b = 6, 4, 5, 6
fares = [[2,6,6], [6,3,7], [4,6,7], [6,5,11], [2,5,12], [5,3,20], [2,4,8], [4,3,9]]
print(solution(n, s, a, b, fares)) # 18
