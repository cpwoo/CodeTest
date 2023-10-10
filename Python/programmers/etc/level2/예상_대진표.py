def solution(n,a,b):
    answer = 0
    while a != b:
        answer += 1
        a, b = (a+1)>>1, (b+1)>>1
    return answer


n,a,b = 8,4,7
print(solution(n,a,b)) # 3
