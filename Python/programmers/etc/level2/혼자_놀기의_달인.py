def solution(cards):
    answer = []
    n = len(cards)
    for i in range(n):
        tmp = []
        while cards[i] not in tmp:
            tmp.append(cards[i])
            i = cards[i]-1
        answer.append(sorted(tmp) if sorted(tmp) not in answer else [])
    answer.sort(reverse=True, key=len)
    return len(answer[0])*len(answer[1])


cards = [8,6,3,7,2,5,1,4]
print(solution(cards)) # 12
