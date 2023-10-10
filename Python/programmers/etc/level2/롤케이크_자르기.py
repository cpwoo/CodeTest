from collections import Counter

def solution(topping):
    answer = 0
    bro = Counter(topping)
    chul = set()
    for i in topping:
        bro[i] -= 1
        if bro[i] == 0:
            del bro[i]
        chul.add(i)
        if len(bro) == len(chul):
            answer += 1
    return answer


topping = [1, 2, 1, 3, 1, 4, 1, 2]
print(solution(topping)) # 2

topping = [1, 2, 3, 1, 4]
print(solution(topping)) # 0
