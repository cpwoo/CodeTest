import sys
input = lambda: sys.stdin.readline().rstrip()

INF = sys.maxsize

def solve(x):
    return sum([abs(arr[i]-x*i) for i in range(N)])


N = int(input())
arr = list(map(int, input().split()))

start, end = 1, 1_000_000_000
while end-start >= 3:
    left, right = (start*2+end)//3, (start+end*2)//3
    if solve(left) < solve(right):
        end = right
    else:
        start = left

_min = INF
for i in range(start, end+1):
    _min = min(_min, solve(i))

print(_min)
