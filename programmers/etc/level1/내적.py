def solution(a, b):
    answer = 0
    for i in range(len(a)):
        answer += a[i]*b[i]
    return answer

a, b = [1,2,3,4], [-3,-1,0,2]
print(solution(a, b)) # 3

a, b = [-1,0,1], [1,0,-1]
print(solution(a, b)) # -2
