def solution(edges, target):
    n = len(edges)+1
    adj = [[] for _ in range(n)]
    for a, b in edges:
        adj[a-1].append(b-1)
    
    for i in range(n):
        adj[i].sort()
    
    T = 0
    for i in range(n):
        if len(adj[i]) == 0 and target[i]:
            T += 1

    pos, cnt = [0]*n, [0]*n
    C = [0]*n
    q = []
    while T:
        cur = 0
        while len(adj[cur]):
            tmp = cur
            cur = adj[cur][pos[cur]]
            pos[tmp] = (pos[tmp]+1)%len(adj[tmp])
        cnt[cur] += 1
        q.append(cur)
        if cnt[cur] > target[cur]:
            return [-1]
        if not C[cur] and target[cur] <= 3*cnt[cur]:
            C[cur] = 1
            T -= 1
    
    answer = []
    for i in q:
        cnt[i] -= 1
        for v in [1,2,3]:
            if cnt[i] <= target[i]-v <= 3*cnt[i]:
                answer.append(v)
                target[i] -= v
                break
    
    return answer


edges = [[2, 4], [1, 2], [6, 8], [1, 3], [5, 7], [2, 5], [3, 6], [6, 10], [6, 9]]
target = [0, 0, 0, 3, 0, 0, 5, 1, 2, 3]
print(solution(edges, target)) # [1, 1, 2, 2, 2, 3, 3]

edges = [[1, 2], [1, 3]]
target = [0, 7, 3]
print(solution(edges, target)) # [1, 1, 3, 2, 3]

edges = [[1, 3], [1, 2]]
target = [0, 7, 1]
print(solution(edges, target)) # [-1]
