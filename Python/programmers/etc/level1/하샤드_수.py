def solution(x):
    return x%sum([int(i) for i in str(x)]) == 0

x = 10
print(solution(x)) # True

x = 11
print(solution(x)) # True

x = 12
print(solution(x)) # False

x = 13
print(solution(x)) # False
