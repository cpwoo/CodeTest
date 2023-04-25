def solution(s):
    answer = []
    for st in s.split(" "):
        tmp = ""
        for idx, p in enumerate(st):
            if idx == 0:
                tmp += p.upper() if p.isalpha() else p
            else:
                tmp += p.lower()
        answer.append(tmp)
    return " ".join(answer)


s = "3people unFollowed me"
print(solution(s)) # "3people Unfollowed Me"

s = "for the last week"
print(solution(s)) # "For The Last Week"
