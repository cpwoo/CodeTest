def solution(s):
    answer = len(s)
    for x in range(1, len(s)//2+1):
        d = 0
        comp = ""
        c = 1
        for i in range(0, len(s), x):
            tmp = s[i:i+x]
            if comp == tmp:
                c += 1
            elif comp != tmp:
                d += len(tmp)
                if c > 1:
                    d += len(str(c))
                c = 1
                comp = tmp
        if c > 1:
            d += len(str(c))
        answer = min(answer, d)
    return answer


s = "aabbaccc"
print(solution(s)) # 7

s = "ababcdcdababcdcd"
print(solution(s)) # 9

s = "abcabcdede"
print(solution(s)) # 8

s = "abcabcabcabcdededededede"
print(solution(s)) # 14

s = "xababcdcdababcdcd"
print(solution(s)) # 17
