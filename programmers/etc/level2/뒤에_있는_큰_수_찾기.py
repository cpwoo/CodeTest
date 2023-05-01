def solution(numbers):
    dp = [-1]*len(numbers)
    stack = []
    for idx, number in enumerate(numbers):
        while stack and numbers[stack[-1]] < number:
            dp[stack.pop()] = number
        stack.append(idx)
    return dp


numbers = [2, 3, 3, 5]
print(solution(numbers)) # [3, 5, 5, -1]

numbers = [9, 1, 5, 3, 6, 2]
print(solution(numbers)) # [-1, 5, 6, 6, -1, -1]
