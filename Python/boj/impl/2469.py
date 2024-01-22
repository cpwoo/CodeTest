import sys
input = lambda: sys.stdin.readline().rstrip()

k, n = int(input()), int(input())
start = [chr(ord("A")+i) for i in range(k)]
target = list(input())
arr = [list(input()) for _ in range(n)]

idx = -1
for i in range(n):
    if arr[i][0] == "?":
        idx = i
        break

for i in range(idx):
    for j in range(k-1):
        if arr[i][j] == "-":
            start[j], start[j+1] = start[j+1], start[j]

for i in range(n-1, idx, -1):
    for j in range(k-1):
        if arr[i][j] == "-":
            target[j], target[j+1] = target[j+1], target[j]

answer = []
for i in range(k-1):
    if start[i] == target[i]:
        answer.append("*")
    else:
        if start[i] == target[i+1]:
            answer.append("-")
        elif i > 0 and start[i] == target[i-1]:
            answer.append("*")
        else:
            answer = ["x"]*(k-1)
            break

print("".join(answer))
