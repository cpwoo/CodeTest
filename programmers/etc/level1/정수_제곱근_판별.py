def solution(n):
    return -1 if (n**0.5)%1 != 0 else (int(n**0.5)+1)**2


n = 121
print(solution(n)) # 144

n = 3
print(solution(n)) # -1
