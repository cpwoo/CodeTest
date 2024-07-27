import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
switch = [list(map(int, input())) for _ in range(n)]
k = int(input())

answer = 0
for i in switch:
    tmp = i.count(0)
    if tmp <= k and tmp%2 == k%2: # 위 조건을 만족해야 i 를 모두 킬 수 있다.
        cnt = 0
        for j in switch: # 다시 한번 행을 반복하면서
            if i == j: # 두 행의 상태가 같으면 1 추가
                cnt += 1
        answer = max(answer, cnt)

print(answer)
