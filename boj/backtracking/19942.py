import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(idx, tot, p, f, s, v, visited):
    if idx == N:
        if mp <= p and mf <= f and ms <= s and mv <= v:
            tmp = [tot]
            for i in range(N):
                if visited[i]:
                    tmp.append(i+1)
            ans.append(tmp)
        return
    
    visited[idx] = True
    np, nf, ns, nv, nt = arr[idx]
    dfs(idx+1, tot+nt, p+np, f+nf, s+ns, v+nv, visited)
    visited[idx] = False
    dfs(idx+1, tot, p, f, s, v, visited)
    

N = int(input())
mp, mf, ms, mv = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [False]*N

ans = []
dfs(0, 0, 0, 0, 0, 0, visited)
ans.sort()

if not ans:
    print(-1)
else:
    print(ans[0][0])
    print(*ans[0][1:])
