def solution(money):
    n = len(money)
    
    if n == 1: return money[0]
    
    # 첫 번째 뜯은 경우, 아닌 경우
    d1, d2 = [0]*n, [0]*n
    
    d1[0] = money[0]
    d1[1] = d1[0]
    for i in range(2, n-1):
        d1[i] = max(d1[i-2]+money[i], d1[i-1])
    
    for i in range(1, n):
        d2[i] = max(d2[i-2]+money[i], d2[i-1])
    
    return max(d1[-2], d2[-1])


money = [1, 2, 3, 1]
print(solution(money)) # 4
