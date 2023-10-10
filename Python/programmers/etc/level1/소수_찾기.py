def solution(n):
    sieve = [True]*1000001
    sieve[0] = sieve[1] = False
    for i in range(2, 1001):
        if sieve[i]:
            for j in range(2*i, 1000001, i):
                sieve[j] = False
    return sieve[:n+1].count(True)


n = 10
print(solution(n)) # 4

n = 5
print(solution(n)) # 3
