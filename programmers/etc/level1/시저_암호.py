def solution(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i] = chr((ord(s[i])-ord('A')+n)%26+ord('A'))
        elif s[i].islower():
            s[i] = chr((ord(s[i])-ord('a')+n)%26+ord('a'))
    return "".join(s)


s, n = "AB", 1
print(solution(s, n)) # "BC

s, n = "z", 1
print(solution(s, n)) # "a"

s, n = "a B z", 4
print(solution(s, n)) # "e F d"
