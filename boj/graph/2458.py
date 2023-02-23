import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
arr = [[0]*N for _ in range(N)]
for _ in range(M):
    v, e = map(int, input().split())
    arr[v-1][e-1] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            if arr[i][k] == 1 and arr[k][j] == 1:
                arr[i][j] = 1

answer = 0
for i in range(N):
    check = 0
    for j in range(N):
        check += arr[i][j] + arr[j][i]
    
    if check == N-1:
        answer += 1

print(answer)
