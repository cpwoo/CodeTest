import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**6)

def dfs(x):
    global result
    visited[x] = True
    cycle.append(x)
    number = numbers[x]
    
    if visited[number]:
        if number in cycle:
            result += cycle[cycle.index(number):]
        return
    else:
        dfs(number)

for _ in range(int(input())):
    n = int(input())
    numbers = [0] + list(map(int, input().split()))
    visited = [True] + [False]*n
    result = []
    
    for i in range(1, n+1):
        if not visited[i]:
            cycle = []
            dfs(i)
            
    print(n-len(result))
