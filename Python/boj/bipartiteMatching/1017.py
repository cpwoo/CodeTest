import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(x):
    if visited[Y.index(x)]: return False
    visited[Y.index(x)] = True
    for y in Y:
        if x+y in primes:
            if y not in matched or dfs(matched[y]):
                matched[y] = x
                return True
    return False


n = int(input())
X = list(map(int, input().split()))

primes = []
for i in range(2, 2000):
    is_prime = True
    for j in range(2, i):
        if i%j == 0:
            is_prime = False
            break
    if is_prime: primes.append(i)

answer = []
for x in X:
    matched = {}
    if x == X[0]: continue
    if X[0]+x in primes:
        if n == 2:
            answer.append(x)
            break
        Y = X[:]
        del Y[0]
        del Y[Y.index(x)]
        for y in Y:
            visited = [False]*(n-2)
            dfs(y)
    if n != 2 and len(matched) == n-2:
        answer.append(x)

if not answer:
    print(-1)
else:
    answer.sort()
    print(*answer)
