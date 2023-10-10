import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(cnt):
    if cnt == len(s):
        print(''.join(answer))
        return
    
    for k in visited:
        if visited[k]:
            visited[k] -= 1
            answer.append(k)
            dfs(cnt+1)
            visited[k] += 1
            answer.pop()


for _ in range(int(input())):
    s = sorted(list(input()))
    visited = {}
    answer = []

    for i in s:
        if i in visited:
            visited[i] += 1
        else:
            visited[i] = 1
    
    dfs(0)
