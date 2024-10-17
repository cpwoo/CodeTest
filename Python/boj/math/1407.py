import sys
input = lambda: sys.stdin.readline().rstrip()

def calc(x):
    ret = x
    mul = 2
    
    while mul <= x:
        ret += (x//mul)*(mul//2)
        mul <<= 1
    
    return ret


a, b = map(int, input().split())
print(calc(b)-calc(a-1))
