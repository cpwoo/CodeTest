import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
if n%5 == 2 or n%5 == 0:
    print("CY")
else:
    print("SK")
