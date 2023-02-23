import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n = int(input())
    graph = [[] for _ in range(n+1)]
    
    for _ in range(n-1):
        p, c = map(int, input().split())
        graph[c] = p
        
    a, b = map(int, input().split())
    
    p1 = [a]
    p2 = [b]
    
    while graph[a]:
        p1.append(graph[a])
        a = graph[a]
    
    while graph[b]:
        p2.append(graph[b])
        b = graph[b]
    
    aLevel = len(p1)-1
    bLevel = len(p2)-1
    
    while p1[aLevel] == p2[bLevel]:
        aLevel -= 1
        bLevel -= 1
    
    print(p1[aLevel+1])
