from collections import Counter

def solution(X, Y):
    answer = ""
    X, Y = Counter(X), Counter(Y)
    for i in range(9, -1, -1):
        cnt = min(X[str(i)], Y[str(i)])
        answer += str(i)*cnt
    if not answer:
        return "-1"
    elif answer[0] == "0":
        return "0"
    return answer


X, Y = "100", "2345"
print(solution(X, Y)) # "-1"

X, Y = "100", "203045"
print(solution(X, Y)) # "0"

X, Y = "100", "123450"
print(solution(X, Y)) # "10"

X, Y = "12321", "42531"
print(solution(X, Y)) # "321"

X, Y = "5525", "1255"
print(solution(X, Y)) # "552"
