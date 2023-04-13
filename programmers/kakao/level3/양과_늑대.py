def solution(info, edges):
    visited = [0]*len(info)
    visited[0] = 1
    answer = []

    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        for i in range(len(edges)):
            parent, child = edges[i][0], edges[i][1]
            if visited[parent] and not visited[child]:
                visited[child] = 1
                dfs(sheep+(info[child]==0), wolf+(info[child]==1))
                visited[child] = 0
    
    dfs(1, 0)
    return max(answer)


info = [0,0,1,1,1,0,1,0,1,0,1,1]
edges = [[0,1],[1,2],[1,4],[0,8],[8,7],[9,10],[9,11],[4,3],[6,5],[4,6],[8,9]]
print(solution(info, edges)) # 5

info = [0,1,0,1,1,0,1,0,0,1,0]
edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6],[3,7],[4,8],[6,9],[9,10]]
print(solution(info, edges)) # 5
