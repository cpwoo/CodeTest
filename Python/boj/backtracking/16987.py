import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(eggs, idx):
    global answer
    if idx == n:
        answer = max(answer, len([s for s,_ in eggs if s<1]))
        return
    
    if eggs[idx][0] < 1:
        dfs(eggs, idx+1)
        return
    
    if len([s for s,_ in eggs if s<1]) >= n-1:
        answer = max(answer, n-1)
        return
    
    for target in range(n):
        if target != idx and eggs[target][0] > 0:
            eggs[target][0] -= eggs[idx][1]
            eggs[idx][0] -= eggs[target][1]
            dfs(eggs, idx+1)
            eggs[target][0] += eggs[idx][1]
            eggs[idx][0] += eggs[target][1]


n = int(input())
eggs = [list(map(int, input().split())) for _ in range(n)]
answer = 0
            
dfs(eggs, 0)
print(answer)
