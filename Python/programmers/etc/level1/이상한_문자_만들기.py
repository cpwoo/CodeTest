def solution(s):
    answer = []
    # 주의사항: split(" ")이 아닌 split()은 공백을 전부 없애기 때문에 조건에 맞지 않음
    for st in s.split(" "):
        tmp = ""
        for i in range(len(st)):
            if ~i&1:
                tmp += st[i].upper()
            else:
                tmp += st[i].lower()
        answer.append(tmp)
    return " ".join(answer)


s = "try hello world"
print(solution(s)) # "TrY HeLlO WoRlD"
