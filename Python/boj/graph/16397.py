import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(start):
    q = deque()
    visited = [0]*100000
    q.append((start, 0))
    visited[start] = 1

    while q:
        cur, cost = q.popleft()
        if cost > T:
            return "ANG"
        if cur == G:
            return cost
        
        if cur+1 < 100000 and not visited[cur+1]:
            q.append((cur+1, cost+1))
            visited[cur+1] = 1
        if cur*2 < 100000:
            t = str(cur*2)
            if int(t) != 0:
                t = str(int(t[0])-1) + t[1:]
            if not visited[int(t)]:
                q.append((int(t), cost+1))
                visited[int(t)] = 1
    
    return "ANG"


N, T, G = map(int, input().split())

print(bfs(N))
