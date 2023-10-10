from itertools import product

def solution(word):
    return sorted(["".join(c) for i in range(5) for c in product("AEIOU", repeat=i+1)]).index(word)+1


word = "AAAAE"
print(solution(word)) # 6

word = "AAAE"
print(solution(word)) # 10

word = "I"
print(solution(word)) # 1563

word = "EIO"
print(solution(word)) # 1189
