import sys
input = lambda: sys.stdin.readline().rstrip()

def sol(n, k, l):
    L = 2*l + k + 3
    if n <= 3:
        print(moo[n-1])
        exit()
    if L < n:
        sol(n, k+1, L)
    else:
        if l < n <= l+k+3:
            if n-l != 1:
                print("o")
            else:
                print("m")
            exit()
        else:
            sol(n-(l+k+3), 1, 3)

n = int(input())
moo = ["m", "o", "o"]
sol(n, 1, 3)
