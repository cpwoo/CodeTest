import sys
input = lambda: sys.stdin.readline().rstrip()

C, P = map(int, input().split())
height = list(map(int, input().split()))

ret = 0

if P == 1:
    ret += C
    for i in range(C-3):
        if(height[i] == height[i+1] and height[i+1] == height[i+2] and height[i+2] == height[i+3]):
            ret += 1

if P == 2:
    for i in range(C-1):
        if(height[i] == height[i+1]): 
            ret += 1
    
if P == 3:
    for i in range(C-2):
        if(height[i] == height[i+1] and height[i+1] == height[i+2]-1):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]+1):
            ret += 1

if P == 4:
    for i in range(C-2):
        if(height[i] == height[i+1]+1 and height[i+1] == height[i+2]):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]-1):
            ret += 1

if P == 5:
    for i in range(C-2):
        if(height[i] == height[i+1] and height[i+1] == height[i+2]):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]+1 and height[i+1] == height[i+2]-1):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]-1):
            ret += 1
        if(height[i] == height[i+1]+1):
            ret += 1

if P == 6:
    for i in range(C-2):
        if(height[i] == height[i+1] and height[i+1] == height[i+2]):
            ret += 1
        if(height[i] == height[i+1]-1 and height[i+1] == height[i+2]):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]):
            ret += 1
        if(height[i] == height[i+1]+2):
            ret += 1

if P == 7:
    for i in range(C-2):
        if(height[i] == height[i+1] and height[i+1]==height[i+2]):
            ret += 1
        if(height[i] == height[i+1] and height[i+1] == height[i+2]+1):
            ret += 1
    for i in range(C-1):
        if(height[i] == height[i+1]-2):
            ret += 1
        if(height[i] == height[i+1]):
            ret += 1

print(ret)
