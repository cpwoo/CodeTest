import sys
input = lambda: sys.stdin.readline().rstrip()

# 뤼카의 정리
# n과 k를 m으로 나눈 나머지를 n0, k0라 하자.
# n과 k를 m으로 나눈 몫을 구하고, 그 몫을 다시 m으로 나눈 나머지가 n1, k1
# 위 작업을 둘 다 0이 될 때까지 반복하고, 모든 nCk를 곱한 후 나머지 연산 적용

def sol(n, k):
    a = 1
    if n < k:
        return 0
    elif n == k:
        return 1
    for i in range(1, k+1):
        a *= (n-i+1)
        a //= i
    return a


n, k, m = map(int, input().split())

ans = 1
while n or k:
    ans = ans * sol(n%m,k%m) % m
    n //= m; k //= m

print(ans)
