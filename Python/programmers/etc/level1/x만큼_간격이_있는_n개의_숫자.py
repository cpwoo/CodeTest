def solution(x, n):
    return [x*i for i in range(1, n+1)]


x, n = 2, 5
print(solution(x, n)) # [2,4,6,8,10]

x, n = 4, 3
print(solution(x, n)) # [4,8,12]

x, n = -4, 2
print(solution(x, n)) # [-4,-8]
