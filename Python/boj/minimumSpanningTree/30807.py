import sys
input = lambda: sys.stdin.readline().rstrip()

class DisjointSet:
    def __init__(self, N):
        self.parent = [i for i in range(N+1)]
    
    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, a, b):
        a, b = self.find(a), self.find(b)
        if a == b:
            return False
        self.parent[b] = a
        return True

def mst(N, G, t):
    E = []
    for u, v, l, r in G:
        c = min(t, r-l)
        E.append((u, v, l+c))
        t -= c
    E.sort(key=lambda t: t[2])

    dsu = DisjointSet(N)
    tot = 0
    for x, y, c in E:
        if dsu.union(x, y):
            tot += c
    return tot

def main():
    N, M, K = map(int, input().split())
    G = [list(map(int, input().split())) for _ in range(M)]
    X = sum(r-l for _,_,l,r in G)

    s, e = -1, X
    while s+1 < e:
        m = (s+e)//2
        if mst(N, G, m) >= K:
            e = m
        else:
            s = m
    
    if mst(N, G, e) == K:
        print("YES")
        for _, _, l, r in G:
            c = min(e, r-l)
            print(min(l+c, r))
            e -= c
    else:
        print("NO")

if __name__ == "__main__":
    main()
