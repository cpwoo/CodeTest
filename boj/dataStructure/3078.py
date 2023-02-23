import sys
input = lambda: sys.stdin.readline().rstrip()

N, K = map(int, input().split())
student = [0]*N
num = [0]*21
cnt = 0

for i in range(N):
    student[i] = len(input())
    if i > K:
        num[student[i-K-1]] -= 1
    cnt += num[student[i]]
    num[student[i]] += 1

print(cnt)
