def solution(t, p):
    answer = 0
    T, P = len(t), len(p)
    for i in range(T-P+1):
        tmp = t[i:i+P]
        if tmp <= p:
            answer += 1
    return answer


t, p = "3141592", "271"
print(solution(t, p)) # 2

t, p = "500220839878", "7"
print(solution(t, p)) # 8

t, p = "10203", "15"
print(solution(t, p)) # 3
