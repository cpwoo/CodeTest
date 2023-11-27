import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

_max = max(max(A), max(B))
ret = []
for i in range(_max, 0, -1):
    while True:
        if i not in A or i not in B:
            break

        ret.append(i)
        A = A[A.index(i)+1:]
        B = B[B.index(i)+1:]

print(len(ret))
print(*ret)
