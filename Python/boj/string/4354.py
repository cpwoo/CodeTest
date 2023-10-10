import sys
input = lambda: sys.stdin.readline().rstrip()

# KMP algorithm
# ans = 1 if len(s) % (len(s)-failure func의 마지막 값) != 0 else len(s) // (len(s)-failure func의 마지막 값)

def failure(p):
    tmp = [0] * len(p)

    j = 0
    for i in range(1, len(p)):
        while j > 0 and p[i] != p[j]:
            j = tmp[j-1]
        
        if p[i] == p[j]:
            j += 1
            tmp[i] = j
        
    return tmp


while True:
    s = input()

    if s == '.': break

    table = failure(s)

    print(1 if len(s) % (len(s)-table[-1]) != 0 else len(s) // (len(s)-table[-1]))
