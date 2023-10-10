def solution(numbers, target):

    def dfs(numbers, target, idx, cur):
        if idx == len(numbers):
            return 1 if cur == target else 0
        return dfs(numbers, target, idx+1, cur+numbers[idx]) + dfs(numbers, target, idx+1, cur-numbers[idx])
    
    return dfs(numbers, target, 0, 0)


numbers = [1, 1, 1, 1, 1]
target = 3
print(solution(numbers, target)) # 5

numbers = [4, 1, 2, 1]
target = 4
print(solution(numbers, target)) # 2
