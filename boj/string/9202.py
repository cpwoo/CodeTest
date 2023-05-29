import sys
input = lambda: sys.stdin.readline().rstrip()

dr, dc = [-1,1,0,0,-1,1,-1,1], [0,0,-1,1,-1,-1,1,1]

class Node:
    def __init__(self):
        self.nxt = [0]*26
        self.idx = -1

class Trie:
    def __init__(self):
        self.node = [Node()]
    def insert(self, s, idx):
        cur = 0
        for i in s:
            if self.node[cur].nxt[ord(i)-ord("A")] == 0:
                self.node[cur].nxt[ord(i)-ord("A")] = len(self.node)
                self.node.append(Node())
            cur = self.node[cur].nxt[ord(i)-ord("A")]
        self.node[cur].idx = idx

def get(length):
    if length <= 2: return 0
    elif length <= 4: return 1
    elif length == 5: return 2
    elif length == 6: return 3
    elif length == 7: return 5
    elif length == 8: return 11

def dfs(r, c, pos):
    if T.node[pos].nxt[ord(board[r][c])-ord("A")] == 0: return
    pos = T.node[pos].nxt[ord(board[r][c])-ord("A")]
    visited[r][c] = 1
    if T.node[pos].idx != -1:
        v.add(T.node[pos].idx)
    for d in range(8):
        nr, nc = r+dr[d], c+dc[d]
        if (0 <= nr < 4) and (0 <= nc < 4) and not visited[nr][nc]:
            dfs(nr, nc, pos)
    visited[r][c] = 0


W = int(input())
words = [input() for _ in range(W)]; input()

T = Trie()
visited = [[0]*4 for _ in range(4)]
for i in range(W):
    T.insert(words[i], i)

for _ in range(int(input())):
    board = [input() for _ in range(4)]
    v = set()
    for i in range(4):
        for j in range(4):
            dfs(i, j, 0)
    score, cnt, mx = 0, 0, ""
    for i in v:
        score += get(len(words[i]))
        cnt += 1
        if len(mx) < len(words[i]) or len(mx) == len(words[i]) and mx > words[i]:
            mx = words[i]
    print(score, mx, cnt); input()
