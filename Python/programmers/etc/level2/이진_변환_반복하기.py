import re

def solution(s):
    answer = [0, 0]
    while s != "1":
        answer[0] += 1
        answer[1] += list(s).count("0")
        s = re.sub("0", "", s)
        s = bin(len(s))[2:]

    return answer


s = "110010101001"
print(solution(s)) # [3,8]

s = "01110"
print(solution(s)) # [3,3]

s = "1111111"
print(solution(s)) # [4,1]
