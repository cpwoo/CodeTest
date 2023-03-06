import sys
input = lambda: sys.stdin.readline().rstrip()

def SCC(node):
    global idx, scc_num
    visited[node] = idx
    idx += 1
    stack.append(node)
    root = visited[node]
    for nxt in graph[node]:
        if not visited[nxt]:
            root = min(root, SCC(nxt))
        elif not check[nxt]:
            root = min(root, visited[nxt])
    if root == visited[node]:
        cur_scc = []
        while True:
            top = stack.pop()
            check[top] = True
            cur_scc.append(top)
            CNF[top] = scc_num
            if top == node:
                break
        scc_num+=1
        scc_arr.append(cur_scc)
    return root


while True:
    try:
        N, M = map(int, input().split())
        graph = [[] for _ in range(2*N)]
        
        for _ in range(M):
            a, b = map(int, input().split())
            if a < 0 : a = N-a
            if b < 0 : b = N-b
            a -= 1; b -= 1
            graph[(a+N)%(2*N)].append(b)
            graph[(b+N)%(2*N)].append(a)
        graph[N].append(0)

        visited = [False] * (2*N)
        check = [False] * (2*N)
        idx = 1
        scc_num = 0
        CNF = [-1]*(2*N)
        stack = []
        scc_arr = []

        for i in range(2*N):
            if not visited[i]:
                SCC(i)
        for i in range(N):
            if CNF[i] == CNF[N+i]:
                print("no")
                break
        else:
            print("yes")
    except:
        break
