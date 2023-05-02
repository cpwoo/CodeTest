def solution(n, l, r):
    answer = 0

    def check(idx):
        if idx%5 == 2:
            return 0
        elif idx < 5:
            return 1
        else:
            return check(idx//5)

    for i in range(l-1, r):
        answer += check(i)

    return answer


n, l, r = 2, 4, 17
print(solution(n, l, r)) # 8
