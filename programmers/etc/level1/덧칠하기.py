def solution(n, m, section):
    answer = 0
    while section:
        end = section.pop()
        while section and section[-1] > end-m:
            section.pop()
        answer += 1
    return answer


n, m = 8, 4
section = [2, 3, 6]
print(solution(n, m, section)) # 2

n, m = 5, 4
section = [1, 3]
print(solution(n, m, section)) # 1

n, m = 4, 1
section = [1, 2, 3, 4]
print(solution(n, m, section)) # 4
