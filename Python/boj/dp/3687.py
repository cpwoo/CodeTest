import sys
input = lambda: sys.stdin.readline().rstrip()

d = [0,0,1,7,4,2,6,8,10,18,22]

def getMax(n):
    ret = [1]*(n//2)
    if n%2 == 1:
        ret[0] = 7
    return ret

def getMin(n):
    ret = [8]*((n+6)//7)
    if n%7 == 1:
        ret[0] = 1
        ret[1] = 0
    if n%7 == 2:
        ret[0] = 1
    if n%7 == 3:
        ret[0] = 2
        ret[1] = 0
        ret[2] = 0
    if n%7 == 4:
        ret[0] = 2
        ret[1] = 0
    if n%7 == 5:
        ret[0] = 2
    if n%7 == 6:
        ret[0] = 6
    return ret

for _ in range(int(input())):
    n = int(input())
    if n < 11:
        print(d[n], end=" ")
    else:
        print(*getMin(n), sep="", end=" ")
    print(*getMax(n), sep="")
