import sys
input = lambda: sys.stdin.readline().rstrip()

def isPrime(num):
    for i in range(2, int(num**0.5)+1):
        if num%i == 0:
            return False
    return True


a, b = map(int, input().split())

b = min(10_000_000, b)

palindrome = [i for i in range(a, b+1) if str(i) == str(i)[::-1]]

for p in palindrome:
    if isPrime(p):
        print(p)

print(-1)
