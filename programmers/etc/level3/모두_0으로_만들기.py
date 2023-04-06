import sys
sys.setrecursionlimit(10**6)

answer = 0

def dfs(graph, tot, now, parent):
    global answer
    for nxt in graph[now]:
        if nxt != parent:
            dfs(graph, tot, nxt, now)
    tot[parent] += tot[now]
    answer += abs(tot[now])

def solution(a, edges):
    tot = a[:]
    graph = [[] for _ in range(len(a))]
    for i in range(len(edges)):
        graph[edges[i][0]].append(edges[i][1])
        graph[edges[i][1]].append(edges[i][0])
        
    dfs(graph, tot, 0, 0)
    return answer if tot[0] == 0 else -1


a = [-5,0,2,1,2]
edges = [[0,1],[3,4],[2,3],[0,3]]
print(solution(a, edges)) # 9

a = [0,1,0]
edges = [[0,1],[1,2]]
print(solution(a, edges)) # -1
