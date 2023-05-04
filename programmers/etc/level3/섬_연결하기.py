def solution(n, costs):
    
    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]
    
    def union(a, b):
        a, b = find(a), find(b)
        parent[max(a, b)] = min(a, b)
    
    answer = 0
    cnt = 0
    parent = list(range(n))
    costs.sort(key=lambda t: t[2])
    
    for a, b, cost in costs:
        if find(a) != find(b):
            answer += cost
            union(a, b)
            cnt += 1
        if cnt == n-1:
            break
    
    return answer


n = 4
costs = [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
print(solution(n, costs)) # 4
