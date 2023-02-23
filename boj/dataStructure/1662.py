import sys
input = lambda: sys.stdin.readline().rstrip()

s = input()
stack = []
length = 0
tmp = ''

for i in s:
    if i == "(":
        stack.append((tmp, length-1))
        length = 0
    elif i == ")":
        zippedNum, preLength = stack.pop()
        length = (int(zippedNum)*length)+preLength
    else:
        length += 1
        tmp = i

print(length)
