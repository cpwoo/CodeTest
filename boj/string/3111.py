import sys
input = lambda: sys.stdin.readline().rstrip()

A, T = list(input()), input()
B = A[::-1]
L = len(A)

front, back = [], []

AIdx, BIdx = 0, len(T)-1

flag = True

while AIdx <= BIdx:
    if flag:
        front.append(T[AIdx])
        AIdx += 1
        if front[-L:] == A:
            front[-L:] = []
            flag = False
    else:
        back.append(T[BIdx])
        BIdx -= 1
        if back[-L:] == B:
            back[-L:] = []
            flag = True
    
while back:
    front.append(back.pop())
    if front[-L:] == A:
        front[-L:] = []

print("".join(front))
