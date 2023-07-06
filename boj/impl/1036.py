import sys
input = lambda: sys.stdin.readline().rstrip()

def f(x):
    q, r = divmod(x, 36)
    if q:
        if 0 <= r <= 9:
            return f(q)+chr(r+48)
        else:
            return f(q)+chr(r+55)
    else:
        if 0 <= r <= 9:
            return chr(r+48)
        else:
            return chr(r+55)
        

N = int(input())
c = [0]*36
for i in range(N):
    s = input()
    for j in range(len(s)):
        c[int(s[j], 36)] += pow(36, len(s)-j-1)

K = int(input())
A = sorted([[c[i]*(35-i), i] for i in range(36)])
print(f(sum(map(lambda i: c[A[i][1]]*(A[i][1] if i < 36-K else 35), range(36)))))
