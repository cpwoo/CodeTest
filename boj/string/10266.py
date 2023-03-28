import sys
input = lambda: sys.stdin.readline().rstrip()

# pi 배열 이용 
# pi[i] = P의 i까지 부분 문자열에서 prefix==suffix 가 될 수 있는 부분 문자열 중 가장 긴 것의 길이
def get_pi(s):
    f = [0]*len(s)
    j = 0
    for i in range(1, len(s)):
        while j and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1
            f[i] = j
    return f

# kmp algorithm
def kmp(s, t):
    f = get_pi(t)
    j = 0
    for i in range(len(s)):
        while j and s[i] != t[j]:
            j = f[j-1]
        if s[i] == t[j]:
            if j == len(t)-1:
                return 1
            else:
                j += 1
    return 0


n = int(input())
v, w = [0]*360000, [0]*360000

# 환형 구조이기 때문에 한 번 더 붙인다
for i in map(int, input().split()):
    v[i] = 1
v += v

for i in map(int, input().split()):
    w[i] = 1

print("possible" if kmp(v, w) else "impossible")
