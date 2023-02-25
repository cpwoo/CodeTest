import sys
input = lambda: sys.stdin.readline().rstrip()

def traverse(node):
    global last_node
    if node == -1:
        return
    traverse(left[node])
    last_node = node
    traverse(right[node])


left, right = dict(), dict()

n = int(input())
parent = [0] * (n+1)
nCnt = 0
for _ in range(n):
    a, b, c = map(int, input().rstrip().split())
    left[a] = b
    right[a] = c
    
    if b != -1:
        parent[b] = a
        nCnt += 1
    if c != -1:
        parent[c] = a
        nCnt += 1
        
last_node = 0

traverse(1)
move = 0
while last_node != 1:
    move += 1
    last_node = parent[last_node]

print(2*nCnt - move)
