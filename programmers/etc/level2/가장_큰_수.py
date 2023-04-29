def solution(numbers):
    numbers.sort(reverse=True, key = lambda x: str(x)*3) # numbers 원소 3자리수 이하 이용
    numbers = "".join(str(num) for num in numbers)
    return "0" if numbers[0] == "0" else numbers


numbers = [6, 10, 2]
print(solution(numbers)) # "6210"

numbers = [3, 30, 34, 5, 9]
print(solution(numbers)) # "9534330"
