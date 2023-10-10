import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
if n%7 == 2 or n%7 == 0:
    print("CY")
else:
    print("SK")
