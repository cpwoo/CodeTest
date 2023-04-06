def solution(numbers):
    answer = set(range(10))
    answer -= set(numbers)
    return sum(answer)


numbers = [1,2,3,4,6,7,8,0]
print(solution(numbers)) # 14

numbers = [5,8,4,0,6,7,9]
print(solution(numbers)) # 6
