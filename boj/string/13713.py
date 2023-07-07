import sys
input = lambda: sys.stdin.readline().rstrip()

def Z(s):
    n = len(s)
    l, r = -1, -1
    z = [0]*n
    z[0] = n
    for i in range(1, n):
        if i <= r:
            z[i] = min(r-i+1, z[i-l])
        while (i+z[i] < n) and (s[z[i]] == s[i+z[i]]):
            z[i] += 1
        if r < i+z[i]-1:
            l, r = i, i+z[i]-1
    
    return z


s = input()[::-1]
z = Z(s)
for _ in range(int(input())):
    k = int(input())
    print(z[-k])
