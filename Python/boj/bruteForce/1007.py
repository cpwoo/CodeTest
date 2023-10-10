import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations

for _ in range(int(input())):
    n = int(input())
    coords = []
    total_x = 0
    total_y = 0

    for _ in range(n):
        x, y = map(int, input().split())
        coords.append([x, y])
        total_x += x
        total_y += y

    answer = int(1e9)
    com = list(combinations(coords, n//2))
    
    for c in com[:len(com)//2]:
        x1, y1 = 0, 0
        for x, y in c:
            x1 += x
            y1 += y
        x2, y2 = total_x - x1, total_y - y1

        sumOfVector = ((x2-x1)**2 + (y2-y1)**2)**(0.5)
        answer = min(answer, sumOfVector)
    print(answer)
