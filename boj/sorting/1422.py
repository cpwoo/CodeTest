import sys
input = lambda: sys.stdin.readline().rstrip()

def sort(arr):
    for i in range(n):
        for j in range(i+1, n):
            a, b = int(arr[i]+arr[j]), int(arr[j]+arr[i])
            if a < b:
                arr[i], arr[j] = arr[j], arr[i]


k, n = map(int, input().split())
arr = [input() for _ in range(k)]
_max = str(max(map(int, arr)))
arr.extend([_max]*(n-k))
sort(arr)
print("".join(arr))
