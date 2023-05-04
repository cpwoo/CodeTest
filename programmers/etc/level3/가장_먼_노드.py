from collections import deque, defaultdict

def solution(n, edge):
    answer = defaultdict(int)
    graph = [[] for _ in range(n+1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    visited = [0]*(n+1)
    q = deque()
    q.append([1, 0])
    visited[1] = 1
    while q:
        cur, cnt = q.popleft()
        answer[cnt] += 1
        for nxt in graph[cur]:
            if not visited[nxt]:
                visited[nxt] = 1
                q.append([nxt, cnt+1])
    
    return answer[max(answer.keys())]


n = 6
vertex = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
print(solution(n, vertex)) # 3
