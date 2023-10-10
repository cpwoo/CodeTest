def solution(n):
    return sum([int(i) for i in str(n)])


n = 123
print(solution(n)) # 6

n = 987
print(solution(n)) # 24
