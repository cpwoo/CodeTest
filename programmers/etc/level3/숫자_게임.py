def solution(A, B):
    answer = 0
    A.sort(); B.sort()
    
    j = 0
    for i in range(len(A)):
        if A[j] < B[i]:
            answer += 1
            j += 1

    return answer


A, B = [5,1,3,7], [2,2,6,8]
print(solution(A, B)) # 3

A, B = [2,2,2,2], [1,1,1,1]
print(solution(A, B)) # 0
