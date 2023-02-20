import sys
input = lambda: sys.stdin.readline().rstrip()

s = input()
visited = [0] * len(s)
prev = []
prev.append(0)
start, end = 0, len(s)

while 0 in visited:
    arr = sorted(s[start:end])
    if start == end:
        end = prev.pop()-1
        start = prev.pop()
        prev.append(start)
    else:
        for i in range(start, end):
            if arr[0] == s[i] and not visited[i]:
                visited[i] = 1
                start = i+1
                prev.append(start)
                break
        for i in range(len(s)):
            if visited[i] == 1:
                print(s[i], end='')
        print()
