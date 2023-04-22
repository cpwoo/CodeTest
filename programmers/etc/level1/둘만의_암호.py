def solution(s, skip, index):
    answer = ""
    alpha = "abcdefghijklmnopqrstuvwxyz"
    for i in skip:
        alpha = alpha.replace(i, "")
    for i in s:
        answer += alpha[(alpha.find(i)+index)%len(alpha)]
    return answer


s, skip = "aukks", "wbqd"
index = 5
print(solution(s, skip, index)) # "happy"
