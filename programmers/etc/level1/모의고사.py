def solution(answers):
    a = [1,2,3,4,5]
    b = [2,1,2,3,2,4,2,5]
    c = [3,3,1,1,2,2,4,4,5,5]
    score = [0,0,0]
    
    for idx, answer in enumerate(answers):
        if answer == a[idx%len(a)]:
            score[0] += 1
        if answer == b[idx%len(b)]:
            score[1] += 1
        if answer == c[idx%len(c)]:
            score[2] += 1
            
    ret = []
    for idx, s in enumerate(score):
        if s == max(score):
            ret.append(idx+1)
            
    return ret


answers = [1,2,3,4,5]
print(solution(answers)) # [1]

answers = [1,3,2,4,2]
print(solution(answers)) # [1,2,3]
