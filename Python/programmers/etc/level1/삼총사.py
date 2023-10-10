from itertools import combinations

def solution(number):
    answer = 0
    for case in combinations(number, 3):
        if sum(case) == 0:
            answer += 1
    return answer


number = [-2, 3, 0, 2, -5]
print(solution(number)) # 2

number = [-3, -2, -1, 0, 1, 2, 3]
print(solution(number)) # 5

number = [-1, 1, -1, 1]
print(solution(number)) # 0
