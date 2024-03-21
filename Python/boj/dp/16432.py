import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**4)

def dfs(day, history):
    global flag
    if flag: return

    if day == n:
        print("\n".join(history.split()))
        flag = True
        return
    
    for cake in days[day]:
        if day == 0:
            visited[day+1][int(cake)] = True
            dfs(day+1, history+cake+" ")
        elif cake != history[-2] and not visited[day+1][int(cake)]:
            visited[day+1][int(cake)] = True
            dfs(day+1, history+cake+" ")


n = int(input())
days = []
for _ in range(n):
    cakes = input().split()[1:]
    days.append(cakes)

visited = [[False]*10 for _ in range(n+1)]
flag = False
dfs(0, "")

if flag == False: print(-1)
