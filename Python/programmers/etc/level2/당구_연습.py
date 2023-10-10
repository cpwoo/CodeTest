def solution(m, n, startX, startY, balls):
    answer = []
    for bx, by in balls:
        tmp = []
        for x, y in ((-bx, by), (bx, -by), (2*m-bx, by), (bx, 2*n-by)):
            if (startX == bx and (startY > by > y or startY < by < y)):
                continue
            if (startY == by and (startX > bx > x or startX < bx < x)):
                continue
            tmp.append((startX-x)**2 + (startY-y)**2)
        answer.append(min(tmp))
    return answer


m, n, startX, startY = 10, 10, 3, 7
balls = [[7, 7], [2, 7], [7, 3]]
print(solution(m, n, startX, startY, balls)) # [52, 37, 116]
