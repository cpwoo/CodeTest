import sys
input = lambda: sys.stdin.readline().rstrip()

def solution(c):
    global flag

    if len(p) == len(c):
        if p == c:
            flag = True
        return
    
    if c[0] == "B":
        c.reverse()
        c.pop()
        solution(c)
        c.append("B")
        c.reverse()
    
    if c[-1] == "A":
        c.pop()
        solution(c)
        c.append("A")


p, q = list(input()), list(input())
flag = False
solution(q)

print(1 if flag else 0)
