from itertools import combinations

def solution(relation):
    L, R = len(relation), len(relation[0])
    
    candidates = []
    for k in range(1, R+1):
        candidates.extend(combinations(range(R), k))
    
    res = []
    for cand in candidates:
        tmp = [tuple(r[c] for c in cand) for r in relation]
        if len(set(tmp)) == L:
            res.append(cand)
    
    answer = set(res)
    for i in range(len(res)):
        for j in range(i+1, len(res)):
            if len(res[i]) == len(set(res[i]) & set(res[j])):
                answer.discard(res[j])

    return len(answer)


relation = [["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],
            ["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]
print(solution(relation)) # 2
