import sys
input = lambda: sys.stdin.readline().rstrip()

one, two, three, four, five, six = int(input()), int(input()), int(input()), int(input()), int(input()), int(input())

ret = six

ret += five
one = max(0, one-five*11)

while four:
    area = 36-4*4
    area -= min(5, two)*4
    four -= 1
    two = max(0, two-5)
    one = max(0, one-area)
    ret += 1

while three:
    area = 36-9*min(4, three)
    if three >= 4:
        three -= 4
        area = 0
    elif three == 3:
        three = 0
        area -= min(1, two)*4
        two = max(0, two-1)
    elif three == 2:
        three = 0
        area -= min(3, two)*4
        two = max(0, two-3)
    else:
        three = 0
        area -= min(5, two)*4
        two = max(0, two-5)
    
    one = max(0, one-area)
    ret += 1

while two:
    area = 36-4*min(9, two)
    two = max(0, two-9)
    one = max(0, one-area)
    ret += 1

while one:
    one = max(0, one-36)
    ret += 1

print(ret)
