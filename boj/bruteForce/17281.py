import sys
input = lambda: sys.stdin.readline().rstrip()

from itertools import permutations

N = int(input())
data = [list(map(int, input().split())) for _ in range(N)]

people = [1, 2, 3, 4, 5, 6, 7, 8]
answer = 0
for turn in permutations(people, 8):
    turn = list(turn)
    turn = turn[:3] + [0] + turn[3:]
    score = 0
    idx = 0
    for inning in range(1, N+1):
        out_cnt = 0
        base_1, base_2, base_3 = 0, 0, 0
        while out_cnt < 3:
            if data[inning-1][turn[idx]] == 0:
                out_cnt += 1
            elif data[inning-1][turn[idx]] == 1:
                score += base_3
                base_1, base_2, base_3 = 1, base_1, base_2
            elif data[inning-1][turn[idx]] == 2:
                score += (base_2 + base_3)
                base_1, base_2, base_3 = 0, 1, base_1
            elif data[inning-1][turn[idx]] == 3:
                score += (base_1 + base_2 + base_3)
                base_1, base_2, base_3 = 0, 0, 1
            elif data[inning-1][turn[idx]] == 4:
                score += (base_1 + base_2 + base_3 + 1)
                base_1, base_2, base_3 = 0, 0, 0
            idx += 1
            if idx == 9:
                idx = 0
    answer = max(answer, score)

print(answer)
