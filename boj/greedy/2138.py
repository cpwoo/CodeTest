import sys
input = lambda: sys.stdin.readline().rstrip()

def change(A, B):
    L = A[:]
    press = 0
    for i in range(1, n):
        if L[i-1] == B[i-1]:
            continue
        press += 1
        for j in range(i-1, i+2):
            if j < n:
                L[j] = 1 - L[j]
    return press if L == B else int(1e9)

n = int(input())
s1 = list(map(int, input()))
s2 = list(map(int, input()))

res = change(s1, s2)

s1[0] = 1 - s1[0]
s1[1] = 1 - s1[1]

res = min(res, change(s1, s2)+1)
print(res if res != int(1e9) else -1)
