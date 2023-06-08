import sys
input = lambda: sys.stdin.readline().rstrip()

def f(n):
    x = n%4
    if x == 0:
        return n
    elif x == 1:
        return 1
    elif x == 2:
        return n+1
    else:
        return 0
    
a, b = map(int, input().split())
print(f(a-1)^f(b))
