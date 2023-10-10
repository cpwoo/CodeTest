import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import deque

for _ in range(int(input())):
    a, b = map(int, input().split())
    q = deque()
    q.append([a, ""])
    visited = [False] * 10000
    visited[a] = True

    while q:
        num, path = q.popleft()
        if num == b:
            print(path)
            break

        # D
        num2 = (2*num)%10000
        if not visited[num2]:
            q.append([num2, path+"D"])
            visited[num2] = True
        
        # S
        num2 = (num-1)%10000
        if not visited[num2]:
            q.append([num2, path+"S"])
            visited[num2] = True

        # L
        num2 = (10*num+(num//1000))%10000
        if not visited[num2]:
            q.append([num2, path+"L"])
            visited[num2] = True

        # R
        num2 = (num//10+(num%10)*1000)%10000
        if not visited[num2]:
            q.append([num2, path+"R"])
            visited[num2] = True
