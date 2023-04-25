def solution(A, B):
    return sum([a*b for a, b in zip(sorted(A), sorted(B, reverse=True))])


A, B = [1, 4, 2], [5, 4, 4]
print(solution(A, B)) # 29

A, B = [1, 2], [3, 4]
print(solution(A, B)) # 10
