import sys
input = lambda: sys.stdin.readline().rstrip()

# if (X+Y)%K == 0 and X%K == i, then Y%K = (K-i)%K

MOD = 1_000_000_007

n, k = map(int, input().split())
arr = list(map(int, input().split()))

# arr의 각 원소들을 k로 나눈 나머지가 어떻게 있는가
c = [0]*k
for a in arr:
    c[a%k] += 1

ans = 1
# 나머지가 i인 것만 들어가든지, 아니면 k-i인 것만 들어가든지, 아니면 둘 다 안 들어가든지
# 나머지가 i, k-i인 수가 하나 이상 들어가는 경우의 수는 각각 (2**c[i])-1, (2**c[k-i])-1
# 둘 중 어떤 수도 들어가지 않는 수는 1, 즉 해당 가능한 나머지를 고르는 수는 (2**c[i])+(2**c[k-i])-1
for i in range(1, (k+1)//2):
    ans = ans*(pow(2, c[i], MOD)+pow(2, c[k-i], MOD)-1)%MOD

# 특히 나머지가 0이거나 k//2 이면 그 많은 원소들 중에서 하나만 들어갈 수 있다.
# 각각의 경우들은 독립적이므로 곱연산이 적절하다.
ans = ans*(c[0]+1)%MOD
if k%2 == 0:
    ans = ans*(c[k//2]+1)%MOD
ans = (ans-(n+1))%MOD

print(ans)
