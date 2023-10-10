import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())

# 좌우 대칭 고려 x, 좌우 대칭 형태
d, s = [0]*31, [0]*31
d[1], d[2] = 1, 3
s[1], s[2], s[3], s[4] = 1, 3, 1, 5

for i in range(3, n+1):
    d[i] = 2*d[i-2]+d[i-1]

for i in range(5, n+1):
    s[i] = 2*s[i-4]+s[i-2]

print((d[n]-s[n])//2 + s[n])
