import sys
input = lambda: sys.stdin.readline().rstrip()

parent, pattern = input(), input()
n, m = len(parent), len(pattern)
table = [0]*m

j = 0
for i in range(1, m):
    while j > 0 and pattern[i] != pattern[j]:
        j = table[j-1]
    if pattern[i] == pattern[j]:
        j += 1
        table[i] = j

j = 0; cnt = 0
loc = []
for i in range(n):
    while j > 0 and parent[i] != pattern[j]:
        j = table[j-1]
    if parent[i] == pattern[j]:
        if j == m-1:
            cnt += 1
            loc.append(i-m+2)
            j = table[j]
        else:
            j += 1

print(cnt)
print(*loc)
