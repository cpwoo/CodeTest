def solution(s):
    return (len(s) == 4 or len(s) == 6) and s.isdigit()


s = "a234"
print(solution(s)) # False

s = "1234"
print(solution(s)) # True
