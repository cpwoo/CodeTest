def solution(r1, r2):
    answer = 0
    for i in range(1, r2+1):
        plus = int((r2**2-i**2)**0.5)
        answer += plus+1
        if i <= r1:
            d = (r1**2-i**2)**0.5
            minus = int(d)
            if d == minus:
                answer -= minus
            else:
                answer -= minus+1
    return answer*4


r1, r2 = 2, 3
print(solution(r1, r2)) # 20
