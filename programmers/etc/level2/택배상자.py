def solution(order):
    assist = []
    cnt = 0
    for i in range(1, len(order)+1):
        assist.append(i)
        while assist and assist[-1] == order[cnt]:
            cnt += 1
            assist.pop()
    return cnt


order = [4, 3, 1, 2, 5]
print(solution(order)) # 2

order = [5, 4, 3, 2, 1]
print(solution(order)) # 5
