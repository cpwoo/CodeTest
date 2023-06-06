import sys
input = lambda: sys.stdin.readline().rstrip()

def chk(word):
    d = colors
    for i in range(len(word)):
        if d.get(0) and word[i:] in names:
            return 1
        if not d.get(word[i]):
            return
        d = d[word[i]]


C, N = map(int, input().split())
colors = {}
for _ in range(C):
    d = colors
    for i in input():
        if not d.get(i):
            d[i] = {}
        d = d[i]
    d[0] = 1
names = {input() for _ in range(N)}

for _ in range(int(input())):
    print("Yes" if chk(input()) else "No")
