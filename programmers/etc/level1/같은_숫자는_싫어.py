def solution(arr):
    answer = []
    for a in arr:
        if answer[-1:] != [a]:
            answer.append(a)
    return answer


arr = [1,1,3,3,0,1,1]
print(solution(arr)) # [1,3,0,1]

arr = [4,4,4,3,3]
print(solution(arr)) # [4,3]
