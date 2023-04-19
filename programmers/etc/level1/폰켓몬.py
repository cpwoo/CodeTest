def solution(nums):
    a, b = len(nums)//2, len(set(nums))
    return a if a < b else b 


nums = [3,1,2,3]
print(solution(nums)) # 2

nums = [3,3,3,2,2,4]
print(solution(nums)) # 3

nums = [3,3,3,2,2,2]
print(solution(nums)) # 2
