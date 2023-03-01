import sys
input = lambda: sys.stdin.readline().rstrip()

# 정점 A에서 연결된 정점들 중 A보다 늦게 탐색되는 정점들에서 A를 거치지 않으면서
# A보다 먼저 탐색되는 정점으로 가는 경로가 없는 경우가 존재하면 A는 단절점

def dfs(cur, parent):
    global num

    # 노드 번호 부여
    num += 1
    node[cur] = num

    # 현재 노드의 값
    ret = node[cur]

    # 인접 노드 탐색
    for nxt in graph[cur]:
        # 부모라면 패스
        if nxt == parent: continue
        # 자식 노드 중 번호를 붙이지 않은 노드가 있다면
        if node[nxt] == 0:
            # 자식 중 최소 번호를 찾아내서
            _min = dfs(nxt, cur)
            # 그 최소 번호가 이 노드보다 크다면
            if _min > node[cur]:
                # 답에 저장
                res.append([min(cur, nxt), max(cur, nxt)])
            # 최소 번호 저장
            ret = min(ret, _min)
        else:
            ret = min(ret, node[nxt])
    return ret


v, e = map(int, input().split())
graph = [[] for _ in range(v+1)]
node = [0]*(v+1)
res = []
num = 0

for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for v in range(1, v+1):
    if node[v] == 0:
        dfs(v, 1)
    
res.sort()
print(len(res))

for r in res:
    print(*r)
