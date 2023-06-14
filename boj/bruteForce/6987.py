import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import combinations

def solution(idx):
    global ans
    if idx == 15:
        ans = 1
        for a in arr:
            if a != [0, 0, 0]:
                ans = 0
                break
        return
    
    p, q = game[idx]
    for x, y in ([0,2], [1,1], [2,0]):
        if arr[p][x] > 0 and arr[q][y] > 0:
            arr[p][x] -= 1
            arr[q][y] -= 1
            solution(idx+1)
            arr[p][x] += 1
            arr[q][y] += 1


answer = []
game = list(combinations(range(6), 2))

for _ in range(4):
    data = list(map(int, input().split()))
    arr = [data[i:i+3] for i in range(0, 16, 3)]
    ans = 0
    solution(0)
    answer.append(ans)

print(*answer)
