def solution(n):
    cnt = 1
    while n != 1:
        if ~n&1:
            n >>= 1
        else:
            n -= 1
            cnt += 1
    return cnt


n = 5
print(solution(n)) # 2

n = 6
print(solution(n)) # 2

n = 5000
print(solution(n)) # 5
