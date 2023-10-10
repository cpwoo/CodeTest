def solution(s):
    s = s.lower()
    return s.count("p") == s.count("y")


s = "pPoooyY"
print(solution(s)) # True

s = "Pyy"
print(solution(s)) # False
