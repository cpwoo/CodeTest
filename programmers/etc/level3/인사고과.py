def solution(scores):
    answer = 1
    
    target = scores[0]
    scores.sort(key=lambda t: (-t[0], t[1]))
    
    _min = 0
    for score in scores:
        if target[0] < score[0] and target[1] < score[1]:
            return -1
        if _min <= score[1]:
            if sum(target) < sum(score):
                answer += 1
            _min = score[1]
            
    return answer


scores = [[2,2],[1,4],[3,2],[3,2],[2,1]]
print(solution(scores)) # 4
