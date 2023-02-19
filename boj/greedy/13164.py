import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
arr = list(map(int, input().split()))
sub = []
for i in range(1, n):
    sub.append(arr[i]-arr[i-1])

sub.sort()

print(sum(sub[:n-k]))
