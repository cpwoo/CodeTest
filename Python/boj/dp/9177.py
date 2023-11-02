import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs(a, b, c):
    q = deque()
    q.append((len(a), len(b), len(c)))
    visited = [[0]*(len(b)+1) for _ in range(len(a)+1)]

    while q:
        la, lb, lc = q.popleft()
        if (la,lb,lc) == (0,0,0):
            return True
        elif lc == 0:
            return False
        if la > 0 and a[la-1] == c[lc-1] and not visited[la-1][lb]:
            visited[la-1][lb] = 1
            q.append((la-1, lb, lc-1))
        if lb > 0 and b[lb-1] == c[lc-1] and not visited[la][lb-1]:
            visited[la][lb-1] = 1
            q.append((la, lb-1, lc-1))
    
    return False


for i in range(int(input())):
    a, b, c = input().split()
    flag = "yes" if bfs(a, b, c) else "no"
    print(f"Data set {i+1}: {flag}")
