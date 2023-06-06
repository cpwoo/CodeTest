import sys
input = lambda: sys.stdin.readline().rstrip()

from collections import defaultdict

class Node:
    def __init__(self):
        self.child = defaultdict(Node)
        self.end = False

class Trie:
    def __init__(self):
        self.root = Node()
    
    def insert(self, word):
        node = self.root
        for w in word:
            node = node.child[w]
        node.end = True

    def search(self, word, n):
        node = self.root
        for i in range(n):
            if node.end:
                if word[i:] in s:
                    return "Yes" 
            if word[i] not in node.child:
                if node.end and word[i:] in s:
                    return 1
                else:
                    return
            node = node.child[word[i]]


C, N = map(int, input().split())
t = Trie()
s = set()
for _ in range(C):
    t.insert(input())
for _ in range(N):
    s.add(input())

for _ in range(int(input())):
    q = input()
    print("Yes" if t.search(q, len(q)) else "No")
