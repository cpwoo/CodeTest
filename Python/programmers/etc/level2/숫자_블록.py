def maxdivisor(n):
    if n == 1:
        return 0
    divisors = []
    for x in range(1, int(n**0.5)+1):
        if n%x == 0:
            if x <= 1e7:
                divisors.append(x)
            if n//x <= 1e7 and n//x != n:
                divisors.append(n//x)
    return max(divisors)

def solution(begin, end):
    return [maxdivisor(n) for n in range(begin, end+1)]


begin, end = 1, 10
print(solution(begin, end)) # [0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
