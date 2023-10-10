import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

for _ in range(int(input())):
    n = int(input())

    graph = [[] for _ in range(n+1)]
    inDegree = [0]*(n+1)
    q = deque()
    answer = []
    flag = False

    team = list(map(int, input().split()))

    for i in range(n-1):
        for j in range(i+1, n):
            graph[team[i]].append(team[j])
            inDegree[team[j]] += 1
    
    m = int(input())
    for _ in range(m):
        a, b = map(int, input().split())
        flag = True

        for i in graph[a]:
            if i == b:
                graph[a].remove(b)
                inDegree[b] -= 1
                graph[b].append(a)
                inDegree[a] += 1
                flag = False

        if flag:
            graph[b].remove(a)
            inDegree[a] -= 1
            graph[a].append(b)
            inDegree[b] += 1

    for i in range(1, n+1):
        if inDegree[i] == 0:
            q.append(i)

    if not q:
        print("IMPOSSIBLE")
        continue

    result = True
    while q:
        if len(q) > 1:
            result = False
            break

        tmp = q.popleft()
        answer.append(tmp)
        for i in graph[tmp]:
            inDegree[i] -= 1
            if inDegree[i] == 0:
                q.append(i)
            elif inDegree[i] < 0:
                result = False
                break

    if not result or len(answer) < n:
        print("IMPOSSIBLE")
    else:
        print(*answer)
