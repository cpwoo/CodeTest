def solution(n, left, right):
    answer = []
    for i in range(left, right+1):
        d, v = divmod(i, n)
        answer.append(max(d, v)+1)
    return answer


n, left, right = 3, 2, 5
print(solution(n, left, right)) # [3,2,2,3]

n, left, right = 4, 7, 14
print(solution(n, left, right)) # [4,3,3,3,4,4,4,4]
