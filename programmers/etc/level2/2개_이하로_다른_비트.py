def solution(numbers):
    answer = []
    for number in numbers:
        if not number&1:
            answer.append(number+1)
        else:
            num = 2
            tmp = number-1
            while tmp <= number:
                tmp = number^num
                if tmp < number:
                    tmp ^= num
                    num <<= 1
                else:
                    tmp ^= num>>1
            answer.append(tmp)
            
    return answer


numbers = [2,7]
print(solution(numbers)) # [3,11]
