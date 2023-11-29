import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())

if (n//2)*(n-n//2) < k:
    print(-1)
    exit()

for i in range(1, n//2+1):
    a, b = i, n-i
    if a*b >= k:
        s = "A"*(a-1)+"B"*(b+1)
        if a-1 != 0:
            k -= (a-1)*(b+1)-(a-1)
        else:
            k -= (a-1)*(b+1)
        s = list(s)
        s[-k-1] = "A"
        print("".join(s))
        break
