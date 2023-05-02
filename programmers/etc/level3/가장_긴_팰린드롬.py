def check(st):
    return st == st[::-1]

def solution(s):
    answer = 0
    n = len(s)
    
    for i in range(n):
        for j in range(i, n):
            if check(s[i:j+1]):
                answer = max(answer, j-i+1)

    return answer


s = "abcdcba"
print(solution(s)) # 7

s = "abacde"
print(solution(s)) # 3
