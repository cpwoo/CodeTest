def solution(arr, divisor):
    answer = []
    for a in arr:
        if a%divisor == 0:
            answer.append(a)
    return sorted(answer) if answer else [-1]


arr = [5, 9, 7, 10]
divisor = 5
print(solution(arr, divisor)) # [5, 10]

arr = [2, 36, 1, 3]
divisor = 1
print(solution(arr, divisor)) # [1, 2, 3, 36]

arr = [3, 2, 6]
divisor = 10
print(solution(arr, divisor)) # [-1]
