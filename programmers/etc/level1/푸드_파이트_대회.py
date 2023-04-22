def solution(food):
    answer = ""
    for idx, f in enumerate(food):
        answer += str(idx)*(f//2)
    answer += "0" + answer[::-1]
    return answer


food = [1, 3, 4, 6]
print(solution(food)) # "1223330333221"

food = [1, 7, 1, 2]
print(solution(food)) # "111303111"
