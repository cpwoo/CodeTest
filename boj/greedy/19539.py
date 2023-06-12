import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

s = sum(arr)
turn = s//3

if s%3:
    print("NO")
else:
    for a in arr:
        turn -= a//2
    print("NO" if turn > 0 else "YES")
