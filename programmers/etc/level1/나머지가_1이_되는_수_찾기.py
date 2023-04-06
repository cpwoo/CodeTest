def solution(n):
    for i in range(1, n):
        if n%i == 1:
            return i

       
n = 10
print(solution(n)) # 3

n = 12
print(solution(n)) # 11
