def solution(s):
    s = list(map(int, s.split()))
    return str(min(s)) + " " + str(max(s))


s = "1 2 3 4"
print(solution(s)) # "1 4"

s = "-1 -2 -3 -4"
print(solution(s)) # "-4 -1"

s = "-1 -1"
print(solution(s)) # "-1 -1"
