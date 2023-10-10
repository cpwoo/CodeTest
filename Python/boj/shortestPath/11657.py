import sys
input = lambda: sys.stdin.readline().rstrip()

INF = int(1e9)

# 가중치가 음수이면 벨만포드 알고리즘 사용
def bellmanFord():
    global check
    
    for t in range(N):
        for i in range(1, N+1):
            for cur_node, cur_weight in graph[i]:
                if d[i] != INF and d[cur_node] > d[i] + cur_weight:
                    d[cur_node] = d[i] + cur_weight
                    if t == N-1:
                        check = False


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

d = [INF] * (N+1)
d[1] = 0
check = True

for _ in range(M):
    A, B, C = map(int, input().split())
    graph[A].append([B, C])

bellmanFord()

if not check:
    print(-1)
else:
    for i in d[2:]:
        print(i if i != INF else -1)
