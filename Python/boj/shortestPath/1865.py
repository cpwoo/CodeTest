import sys
input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)

def bellmanFord():
    global check
    
    for i in range(1, n+1):
        for j in range(1, n+1):
            for vec, wei in graph[j]:
                if d[vec] > wei + d[j]:
                    d[vec] = wei + d[j]
                    if i == n:
                        check = False
        

for _ in range(int(input())):
    n, m, w = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    d = [INF] * (n+1)
    
    for _ in range(m):
        s, e, t = map(int, input().split())
        graph[s].append([e, t])
        graph[e].append([s, t])
        
    for _ in range(w):
        s, e, t = map(int, input().split())
        graph[s].append([e, -t])
    
    check = True
    
    bellmanFord()
    
    print("NO" if check else "YES")
