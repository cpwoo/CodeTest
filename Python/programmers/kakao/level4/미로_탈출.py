import sys
INF = sys.maxsize

from heapq import *

def solution(n, start, end, roads, traps):
    graph = [[] for _ in range(n+1)]
    trap_idx = {t:i for i,t in enumerate(traps)}
    traps = set(traps)
    
    for a, b, w in roads:
        graph[a].append((b, w))
        graph[b].append((a, -w))
    
    q = [(0, start, 0)]
    dist = {}
    
    while q:
        dis, cur, state = heappop(q)
        if dist.get((cur, state), None): continue
        
        dist[(cur, state)] = dis
        
        if cur == end: return dis
    
        direc = 1
        if cur in traps and (state & (1<<trap_idx[cur])):
            direc *= -1
        
        for nxt, w in graph[cur]:
            if nxt in traps and (state & (1<<trap_idx[nxt])):
                w *= -1
            
            if w * direc > 0:
                new_state = state
                if nxt in traps:
                    if state & (1<<trap_idx[nxt]):
                        new_state = state & ~(1<<trap_idx[nxt])
                    else:
                        new_state = state | (1<<trap_idx[nxt])
                heappush(q, (dis+w*direc, nxt, new_state))
    return


n, start, end = 3, 1, 3
roads = [[1, 2, 2], [3, 2, 3]]
traps = [2]
print(solution(n, start, end, roads, traps)) # 5

n, start, end = 4, 1, 4
roads = [[1, 2, 1], [3, 2, 1], [2, 4, 1]]
traps = [2, 3]
print(solution(n, start, end, roads, traps)) # 4
