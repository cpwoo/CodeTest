import sys
input = lambda: sys.stdin.readline().rstrip()

# 기존에 풀던 코사라주 알고리즘 대신 활용도가 높은 타잔 알고리즘 적용
# 인접 정점에 방문하며 자기 자신을 스택에 넣고, 재귀적으로 DFS를 수행
# 인접 정점에 방문했지만, 아직 처리중인 상태일 경우, 작은 값으로 부모값을 갱신
# 부모 노드의 DFS가 끝난 경우, 자신의 id값이 스택에서 나올 때까지 스택에 있는 노드들을 pop하고 scc 배열에 추가
# 만들어진 하나의 scc를 전체 SCC 배열에 추가

sys.setrecursionlimit(10**5)

def SCC(node):
    global idx, scc_num
    visited[node] = idx
    root = idx
    idx += 1
    stack.append(node)

    for nxt in graph[node]:
        if not visited[nxt]:
            root = min(root, SCC(nxt))
        elif not check[nxt]:
            root = min(root, visited[nxt])
    
    if root == visited[node]:
        while stack:
            top = stack.pop()
            check[top] = 1
            scc_idx[top] = scc_num
            if node == top:
                break
        scc_num += 1
    
    return root


n, m = map(int, input().split())
graph = [[] for _ in range(2*n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[-a].append(b)
    graph[-b].append(a)

scc_num = 1
idx = 1
stack = []
scc_idx = [0]*(2*n+1)
check = [0]*(2*n+1)
visited = [0]*(2*n+1)

for i in range(1, 2*n+1):
    if not visited[i]: SCC(i)

result = [0]*n
for i in range(1, n+1):
    if scc_idx[i] == scc_idx[-i]:
        print(0)
        break
    if scc_idx[i] < scc_idx[-i]:
        result[i-1] = 1
else:
    print(1)
    print(*result)
