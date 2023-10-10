def solution(num):
    cnt = 0
    while num != 1:
        if ~num&1:
            num >>= 1
        else:
            num = num*3+1
        cnt += 1
        if cnt == 500:
            return -1
    return cnt


num = 6
print(solution(num)) # 8

num = 16
print(solution(num)) # 4

num = 626331
print(solution(num)) # -1
