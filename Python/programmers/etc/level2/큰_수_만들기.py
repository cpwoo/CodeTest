def solution(number, k):
    answer = []
    
    for num in number:
        while k > 0 and answer and answer[-1] < num:
            answer.pop()
            k -= 1
        answer.append(num)

    return "".join(answer[:len(answer)-k])


number, k = "1924", 2
print(solution(number, k)) # "94"

number, k = "1231234", 3
print(solution(number, k)) # "3234"

number, k = "4177252841", 4
print(solution(number, k)) # "775841"
