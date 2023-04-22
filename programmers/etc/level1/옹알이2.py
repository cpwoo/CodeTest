def solution(babbling):
    answer = 0
    for b in babbling:
        for r in ["aya", "ye", "woo", "ma"]:
            if r*2 not in b:
                b = b.replace(r, " ")
        if len(b.strip()) == 0:
            answer += 1
    return answer


babbling = ["aya", "yee", "u", "maa"]
print(solution(babbling)) # 1

babbling = ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]
print(solution(babbling)) # 2
