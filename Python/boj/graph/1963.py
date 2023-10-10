import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

def bfs():
    q = deque()
    q.append([start, 0])

    visited = [0]*10000
    visited[start] = 1

    while q:
        now, cnt = q.popleft()
        strNow = str(now)

        if now == end:
            return cnt

        for i in range(4):
            for j in range(10):
                tmp = int(strNow[:i] + str(j) + strNow[i+1:])

                if visited[tmp] == 0 and check[tmp] and tmp >= 1000:
                    visited[tmp] = 1
                    q.append([tmp, cnt+1])


check = [True]*10000
for i in range(2, 100):
        if check[i] == True:
            for j in range(2*i, 10000, i):
                check[j] = False

for _ in range(int(input())):
    start, end = map(int, input().split())
    result = bfs()
    print(result if result != None else "Impossible")
