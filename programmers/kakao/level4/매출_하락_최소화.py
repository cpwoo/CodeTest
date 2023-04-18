import sys

def solution(sales, links):
    n = len(sales)
    graph = [[] for _ in range(n)]
    for a, b in links:
        graph[a-1].append(b-1)

    cost = [[0, 0] for _ in range(n)]

    def dfs(sales, node):
        cost[node][0], cost[node][1] = 0, sales[node]
        
        if not graph[node]:
            return
        
        extra = sys.maxsize
        for child in graph[node]:
            dfs(sales, child)
            if cost[child][0] < cost[child][1]:
                cost[node][0] += cost[child][0]
                cost[node][1] += cost[child][0]
                extra = min(extra, cost[child][1]-cost[child][0])
            else:
                cost[node][0] += cost[child][1]
                cost[node][1] += cost[child][1]
                extra = 0
        cost[node][0] += extra

    dfs(sales, 0)

    return min(cost[0][0], cost[0][1])


sales = [14, 17, 15, 18, 19, 14, 13, 16, 28, 17]
links = [[10, 8], [1, 9], [9, 7], [5, 4], [1, 5], [5, 10], [10, 6], [1, 3], [10, 2]]
print(solution(sales, links)) # 44

sales = [5, 6, 5, 3, 4]
links = [[2,3], [1,4], [2,5], [1,2]]
print(solution(sales, links)) # 6

sales = [5, 6, 5, 1, 4]
links = [[2,3], [1,4], [2,5], [1,2]]
print(solution(sales, links)) # 5

sales = [10, 10, 1, 1]
links = [[3,2], [4,3], [1,4]]
print(solution(sales, links)) # 2
