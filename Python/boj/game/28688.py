import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, m = map(int, input().split())
    if n in [1,2] or m in [1,2]:
        print("First")
    elif n%2 == 0:
        print("Second")
    else:
        if m%2 == 1:
            print("First")
        else:
            print("Second")
