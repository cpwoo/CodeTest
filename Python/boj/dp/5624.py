import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

s = set()

answer = 0
s.add(arr[0]+arr[0])

for i in range(1, n):
    for j in range(i):
        if arr[i]-arr[j] in s:
            answer += 1
            break
    for j in range(i+1):
        s.add(arr[i]+arr[j])

print(answer)
