import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = sorted([list(map(int, input().split())) for _ in range(n)], key=lambda t: -t[1])

end = arr[0][1]-arr[0][0]

for i in range(1, n):
    if end > arr[i][1]:
        end = arr[i][1]-arr[i][0]
    else:
        end -= arr[i][0]

print(end if end >= 0 else -1)
