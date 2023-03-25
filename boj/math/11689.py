import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
result = n
for i in range(2, int(n**0.5)+1):
    if n%i == 0:
        while n%i == 0:
            n //= i
        result *= 1 - (1/i)

if n>1:
    result *= 1 - (1/n)
print(int(result))
