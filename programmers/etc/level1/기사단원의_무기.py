def solution(number, limit, power):
    answer = [1]
    for i in range(2, number+1):
        cnt = 0
        for j in range(1, int(i**0.5)+1):
            if i%j == 0:
                cnt += 1
                if j**2 != i:
                    cnt += 1
        if cnt > limit:
            cnt = power
            answer.append(cnt)
        else:    
            answer.append(cnt)
    return sum(answer)


number, limit, power = 5, 3, 2
print(solution(number, limit, power)) # 10

number, limit, power = 10, 3, 2
print(solution(number, limit, power)) # 21
