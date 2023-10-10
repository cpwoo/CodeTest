import sys
INF = sys.maxsize

def solution(N, road, K):
    answer = 0
    
    matrix = [[INF]*N for _ in range(N)]
    for i in range(N):
        matrix[i][i] = 0

    for a, b, c in road:
        matrix[a-1][b-1] = min(matrix[a-1][b-1], c)
        matrix[b-1][a-1] = min(matrix[b-1][a-1], c)
    
    for k in range(N):
        for i in range(N):
            for j in range(N):
                if matrix[i][j] > matrix[i][k] + matrix[k][j]:
                    matrix[i][j] = matrix[i][k] + matrix[k][j]
    
    for i in range(N):
        if matrix[0][i] <= K:
            answer += 1
    
    return answer


N, K = 5, 3
road = [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]]
print(solution(N, road, K)) # 4

N, K = 6, 4
road = [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]]
print(solution(N, road, K)) # 4
