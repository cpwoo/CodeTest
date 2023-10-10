def solution(d, budget):
    d.sort()
    
    for idx, cost in enumerate(d):
        if budget >= cost:
            budget -= cost
        else:
            return idx
    
    return idx+1


d = [1,3,2,5,4]
budget = 9
print(solution(d, budget)) # 3

d = [2,2,3,3]
budget = 10
print(solution(d, budget)) # 4
