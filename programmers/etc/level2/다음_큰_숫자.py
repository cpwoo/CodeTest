def solution(n):
    tmp = n+1
    cnt = bin(n)[2:].count("1")
    while True:
        if cnt == bin(tmp)[2:].count("1"):
            return tmp
        tmp += 1


n = 78
print(solution(n)) # 83

n = 15
print(solution(n)) # 23
