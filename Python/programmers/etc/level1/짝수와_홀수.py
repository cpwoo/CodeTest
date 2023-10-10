def solution(num):
    return "Odd" if num&1 else "Even"


num = 3
print(solution(num)) # "Odd"

num = 4
print(solution(num)) # "Even"
