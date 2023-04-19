def solution(s):
    if len(s)&1:
        return s[len(s)//2]
    else:
        return s[len(s)//2-1:len(s)//2+1]
    

s = "abcde"
print(solution(s)) # "c"

s = "qwer"
print(solution(s)) # "we"
