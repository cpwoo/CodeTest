def nTok(n, k):
    tmp = ""
    while n:
        tmp += str(n%k)
        n //= k
    return tmp

def solution(n):
    answer = int(nTok(n, 3), 3)
    return answer


n = 45
print(solution(n)) # 7

n = 125
print(solution(n)) # 229
