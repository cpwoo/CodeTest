import sys
input = lambda: sys.stdin.readline().rstrip()

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    parent[max(a, b)] = min(a, b)


n, m = map(int, input().split())
impostor = list(map(int, input().split()))[1:]
parent = list(range(n+1))

for i in impostor:
    parent[i] = 0

parties = []
for _ in range(m):
    party = list(map(int, input().split()))[1:]
    for i in range(len(party)-1):
        union(party[i], party[i+1])
    parties.append(party)

ans = 0

for party in parties:
    for i in range(len(party)):
        if find(party[i]) == 0:
            break
    else:
        ans += 1

print(ans)
