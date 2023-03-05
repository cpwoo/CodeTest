import sys
input = lambda: sys.stdin.readline().rstrip()

def ccw(p1, p2, p3):
    result = (p1[0]*p2[1] + p2[0]*p3[1] + p3[0]*p1[1]) - (p1[1]*p2[0] + p2[1]*p3[0] + p3[1]*p1[0])
    return 0 if result == 0 else result // abs(result)


for _ in range(int(input())):
    n, *arr = map(int, input().split())
    points = sorted([[arr[i*2], arr[i*2+1], i] for i in range(n)])

    # cvxh 아래 부분 만들기
    visited = [False]*n
    stack = []
    for i in range(n):
        while len(stack) > 1:
            if ccw(stack[-2], stack[-1], points[i]) >= 0:
                break
            p = stack.pop()
            visited[p[2]] = False
        stack.append(points[i])
        visited[points[i][2]] = True

    # cvxh 아래 부분 아닌 것부터 넣고
    answer = []
    for x, y, i in points:
        if not visited[i]: answer.append(i)
    
    # stack 윗부분부터 넣으면 완성
    for x, y, i in stack[::-1]:
        answer.append(i)

    print(*answer)
