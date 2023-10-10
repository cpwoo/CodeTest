import sys
input = lambda: sys.stdin.readline().rstrip()

p, q = list(input()), list(input())
flag = False

while q:
    if q[-1] == 'A':
        q.pop()
    elif q[-1] == 'B':
        q.pop()
        q.reverse()
    if p == q:
        flag = True
        break

print(1 if flag else 0)
