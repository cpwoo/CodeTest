def solution(s):
    engToNum = {"one":"1", "two":"2", "three":"3",
                "four":"4", "five":"5", "six":"6",
                "seven":"7", "eight":"8", "nine":"9", "zero":"0"}
    for k, v in engToNum.items():
        s = s.replace(k, v)

    return int(s)

s = "one4seveneight"
print(solution(s)) # 1478

s = "23four5six7"
print(solution(s)) # 234567

s = "2three45sixseven"
print(solution(s)) # 234567

s = "123"
print(solution(s)) # 234567
