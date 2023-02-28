import sys
input = lambda: sys.stdin.readline().rstrip()

L = int(input())
s = input()

failure = [0]*L
j = 0
for i in range(1, L):
    while j>0 and s[i] != s[j]:
        j = failure[j-1]
    if s[i] == s[j]:
        j += 1
        failure[i] = j

print(L-failure[-1])
