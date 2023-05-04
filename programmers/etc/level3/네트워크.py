def solution(n, computers):
    
    def dfs(n, computers, i, visited):
        visited[i] = 1
        for j in range(n):
            if i != j and computers[i][j] == 1:
                if not visited[j]:
                    dfs(n, computers, j, visited)
    
    answer = 0
    visited = [0]*n
    for i in range(n):
        if not visited[i]:
            dfs(n, computers, i, visited)
            answer += 1
    
    return answer


n = 3
computers = [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
print(solution(n, computers)) # 2

n = 3
computers = [[1, 1, 0], [1, 1, 1], [0, 1, 1]]
print(solution(n, computers)) # 1
