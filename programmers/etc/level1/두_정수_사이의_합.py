def solution(a, b):
    return (abs(a-b)+1)*(a+b)//2


a, b = 3, 5
print(solution(a, b)) # 12

a, b = 3, 3
print(solution(a, b)) # 3

a, b = 5, 3
print(solution(a, b)) # 12
