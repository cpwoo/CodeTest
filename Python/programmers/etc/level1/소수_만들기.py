from itertools import combinations

def solution(nums):
    sieve = [True]*2998
    sieve[0] = sieve[1] = False
    for i in range(2, int(2998**0.5)+1):
        if sieve[i]:
            for j in range(2*i, 2998, i):
                sieve[j] = False
    
    return sum([sieve[sum(c)] for c in combinations(nums, 3)])


nums = [1,2,3,4]
print(solution(nums)) # 1

nums = [1,2,7,6,4]
print(solution(nums)) # 4
