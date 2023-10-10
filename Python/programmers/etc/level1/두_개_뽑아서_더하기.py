def solution(numbers):
    answer = set()
    for i in range(len(numbers)-1):
        for j in range(i+1, len(numbers)):
            answer.add(numbers[i]+numbers[j])
    answer = sorted(list(answer))
    return answer


numbers = [2,1,3,4,1]
print(solution(numbers)) # [2,1,3,4,1]

numbers = [5,0,2,7]
print(solution(numbers)) # [2,5,7,9,12]
