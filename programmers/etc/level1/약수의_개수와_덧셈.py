def solution(left, right):
    answer = 0
    chk = [True]*1001
    arr = [i*i for i in range(1, 32)]
    for i in range(1001):
        if i in arr:
            chk[i] = False
            
    for i in range(left, right+1):
        if chk[i]:
            answer += i
        else:
            answer -= i
    return answer


left, right = 13, 17
print(solution(left, right)) # 43

left, right = 24, 27
print(solution(left, right)) # 52
