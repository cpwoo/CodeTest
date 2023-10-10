def solution(brown, yellow):
    tot = brown+yellow
    for i in range(1, int(tot**0.5)+1):
        a, b = i, tot//i
        if tot%i == 0 and 2*(a+b-2) == brown:
            return [b, a]
        

brown, yellow = 10, 2
print(solution(brown, yellow)) # [4, 3]

brown, yellow = 8, 1
print(solution(brown, yellow)) # [3, 3]

brown, yellow = 24, 24
print(solution(brown, yellow)) # [8, 6]
