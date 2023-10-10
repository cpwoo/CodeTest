# programmers는 gcd, lcm을 쓸 수가 없다.
def gcd(n, m):
    while m:
        n, m = m, n%m
    return n

def solution(n, m):
    return [gcd(n,m), n*m//gcd(n,m)]


n, m = 3, 12
print(solution(n, m)) # [3, 12]

n, m = 2, 5
print(solution(n, m)) # [1, 10]
