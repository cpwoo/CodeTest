def solution(n):
    answer = ""
    while n:
        if n%3:
            answer = str(n%3)+answer
            n = n//3
        else:
            answer = "4"+answer
            n = (n//3)-1
    return answer


n = 1
print(solution(n)) # "1"

n = 2
print(solution(n)) # "2"

n = 3
print(solution(n)) # "4"

n = 4
print(solution(n)) # "11"
