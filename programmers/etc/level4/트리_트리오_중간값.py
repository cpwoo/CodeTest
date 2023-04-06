from collections import deque

def bfs(tree, start):
    distance = []
    q = deque()
    q.append([start, 0])
    visited = {start: True}    
    while q:
        cur, dist = q.popleft()
        distance.append([cur, dist])        
        for nxt in tree[cur]:
            if nxt not in visited:
                q.append([nxt, dist+1])
                visited[nxt] = True
    return distance

def solution(n, edges):
    tree = {i+1: [] for i in range(n)}
    for edge in edges:
        tree[edge[0]].append(edge[1])
        tree[edge[1]].append(edge[0])
    
    d1 = bfs(tree, 1)
    d2 = bfs(tree, d1[-1][0])
    
    if d1[-1][1] == d1[-2][1]:
        return d2[-1][1]
    else:
        return d2[-2][1]
    

n, edges = 4, [[1,2],[2,3],[3,4]]
print(solution(n, edges)) # 2

n, edges = 5, [[1,5],[2,5],[3,5],[4,5]]
print(solution(n, edges)) # 2
