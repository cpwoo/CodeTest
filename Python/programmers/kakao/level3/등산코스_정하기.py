import sys
from heapq import *
from collections import defaultdict
INF = sys.maxsize

def solution(n, paths, gates, summits):

    def dijkstra():
        q = []
        visited = [INF]*(n+1)

        for gate in gates:
            heappush(q, (0, gate))
            visited[gate] = 0
        
        while q:
            cur_cost, cur_node = heappop(q)
            if cur_node in summits_set:
                continue
            if cur_cost > visited[cur_node]:
                continue
            for nxt_node, nxt_cost in graph[cur_node]:
                cost = max(cur_cost, nxt_cost)
                if cost < visited[nxt_node]:
                    visited[nxt_node] = cost
                    heappush(q, (cost, nxt_node))

        _min = [0, INF]
        for summit in summits:
            if visited[summit] < _min[1]:
                _min = [summit, visited[summit]]
        
        return _min

    summits.sort()
    summits_set = set(summits)
    graph = defaultdict(list)
    for i, j, w in paths:
        graph[i].append((j, w))
        graph[j].append((i, w))

    return dijkstra()


n = 6
paths = [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]
gates, summits = [1, 3], [5]
print(solution(n, paths, gates, summits)) # [5, 3]

n = 7
paths = [[1, 4, 4], [1, 6, 1], [1, 7, 3], [2, 5, 2], [3, 7, 4], [5, 6, 6]]
gates, summits = [1], [2, 3, 4]
print(solution(n, paths, gates, summits)) # [3, 4]

n = 7
paths = [[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]]
gates, summits = [3, 7], [1, 5]
print(solution(n, paths, gates, summits)) # [5, 1]

n = 5
paths = [[1, 3, 10], [1, 4, 20], [2, 3, 4], [2, 4, 6], [3, 5, 20], [4, 5, 6]]
gates, summits = [1, 2], [5]
print(solution(n, paths, gates, summits)) # [5, 6]
