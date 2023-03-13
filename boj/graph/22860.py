import sys
input = lambda: sys.stdin.readline().rstrip()

sys.setrecursionlimit(10**8)

def traverse(p, s):
    global fileCnt
    if p not in direction: return
    
    for f, c in direction[p]:
        if c == '0':
            if f not in s:
                s.add(f)
            fileCnt += 1
        else:
            traverse(f, s)
    return


n, m = map(int, input().split())
direction = {}

for _ in range(n+m):
    p, f, c = input().split()
    if p not in direction:
        direction[p] = []
    direction[p].append([f, c])


for _ in range(int(input())):
    query = input().split('/')
    s = set()
    fileCnt = 0
    traverse(query[-1], s)
    
    print(len(s), fileCnt)
