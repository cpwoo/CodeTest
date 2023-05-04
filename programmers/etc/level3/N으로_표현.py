def solution(N, number):
    if N == number:
        return 1
    s = [set() for _ in range(8)]
    for i, x in enumerate(s):
        x.add(int(str(N)*(i+1)))
        
    for i in range(1, 8):
        for j in range(i):
            for op1 in s[j]:
                for op2 in s[i-j-1]:
                    s[i].add(op1+op2)
                    s[i].add(op1-op2)
                    s[i].add(op1*op2)
                    if op2 != 0:
                        s[i].add(op1//op2)
                        
        if number in s[i]:
            answer = i+1
            break
    else:
        answer = -1
        
    return answer


N, number = 5, 12
print(solution(N, number)) # 4

N, number = 2, 11
print(solution(N, number)) # 3
