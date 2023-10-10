# sorted에 dictionary를 넘기면 dictionary의 keys가 들어간다.

def solution(N, stages):
    answer = {}
    L = len(stages)
    for i in range(1, N+1):
        if L != 0:
            c = stages.count(i)
            answer[i] = c/L
            L -= c
        else:
            answer[i] = 0
        
    return sorted(answer, key=lambda x: answer[x], reverse=True)


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages)) # [3,4,2,1,5]

N = 4
stages = [4,4,4,4,4]
print(solution(N, stages)) # [4,1,2,3]
