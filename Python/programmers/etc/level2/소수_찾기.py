from itertools import permutations

def solution(n):
    s = set()
    for k in range(len(n)):
        s |= set(map(int, map("".join, permutations(list(n), k+1))))
    s -= set(range(0, 2))
    for i in range(2, int(max(s)**0.5) + 1):
        s -= set(range(i*2, max(s)+1, i))
    return len(s)


n = "17"
print(solution(n)) # 3

n = "011"
print(solution(n)) # 2
