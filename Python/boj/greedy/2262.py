import sys
input = lambda: sys.stdin.readline().rstrip()

# 어차피 뒷순위는 떨어지므로 뒷순위부터 뺀다.

n = int(input())
arr = list(map(int, input().split()))

answer = 0

for _ in range(len(arr)-1):
    maxIdx = arr.index(max(arr))

    if maxIdx == 0:
        answer += arr[maxIdx]-arr[maxIdx+1]
    elif maxIdx == len(arr)-1:
        answer += arr[maxIdx]-arr[maxIdx-1]
    else:
        answer += min(arr[maxIdx]-arr[maxIdx+1], arr[maxIdx]-arr[maxIdx-1])
    
    del arr[maxIdx]

print(answer)
