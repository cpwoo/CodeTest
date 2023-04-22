def solution(a, b, n):
    answer = 0
    while n >= a:
        d, m = divmod(n, a)
        answer += d*b
        n = d*b+m
    return answer


a, b, n = 2, 1, 20
print(solution(a, b, n)) # 19

a, b, n = 3, 1, 20
print(solution(a, b, n)) # 9
