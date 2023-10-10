def solution(n, s):
    if n > s: 
        return [-1]
    d, m = divmod(s, n)
    return [d]*(n-m)+[d+1]*m


n, s = 2, 9
print(solution(n, s)) # [4, 5]

n, s = 2, 1
print(solution(n, s)) # [-1]

n, s = 2, 8
print(solution(n, s)) # [4, 4]
