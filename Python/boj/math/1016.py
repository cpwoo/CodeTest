import sys
input = lambda: sys.stdin.readline().rstrip()

a, b = map(int, input().split())
check = [1]*(b-a+1)

i = 2

while i**2 <= b:
    mul = a // (i**2)
    while mul * (i**2) <= b:
        if 0 <= mul * (i**2) - a <= b-a:
            check[mul * (i**2) - a] = 0
        mul += 1
    i += 1

print(sum(check))
