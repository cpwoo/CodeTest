import sys
input = lambda: sys.stdin.readline().rstrip()

MOD = 1_000_000_007

# 최적화를 위해 pow 함수 재정의
def pow(a, b):
    if b == 0: return 1
    if b == 1: return a

    half = pow(a, b//2)
    return (half*half)%MOD if b%2 == 0 else (half*half*a)%MOD

n = int(input())
arr = sorted(list(map(int, input().split())))

answer = 0
for i in range(n):
    answer += arr[i] * (pow(2, i)-pow(2, n-i-1))

print(answer%MOD)
