from math import factorial

def solution(n):
    return factorial(2*n)//(factorial(n)*factorial(n+1))


n = 2
print(solution(n)) # 2

n = 3
print(solution(n)) # 5
