import sys
input = lambda: sys.stdin.readline().rstrip()

# 피사노 주기 : 주기의 길이가 P일 때,
#  N 번째 피보나치 수를 M 으로 나눈 나머지는 N%P 번째 피보나치 수를 M으로 나눈 나머지와 같다.
# 여기서 M = 10**k 이면, k > 2 일 때, P = 15 * (10**k-1) 이다.

n = int(input())

mod = 1_000_000
fibo = [0, 1]
p = mod//10*15

for i in range(2, p):
    fibo.append(fibo[i-1]+fibo[i-2])
    fibo[i] %= mod

print(fibo[n%p])
