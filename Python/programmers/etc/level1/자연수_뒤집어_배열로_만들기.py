def solution(n):
    return [int(i) for i in str(n)][::-1]

n = 12345
print(solution(n)) # [5,4,3,2,1]
