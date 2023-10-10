from collections import defaultdict

def solution(clothes):
    answer = 1
    d = defaultdict(list)
    for c in clothes:
        d[c[1]].append(c[0])
    for k in d:
        answer *= len(d[k])+1
    answer -= 1
    return answer

clothes = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
print(solution(clothes)) # 5

clothes = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]
print(solution(clothes)) # 3
