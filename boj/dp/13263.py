import sys
input = lambda: sys.stdin.readline().rstrip()

# Convex Hull Trick (CHT)
# dp[i] = min(dp[j] + a[i]b[j]) (j < i, b[i-1] >= b[i]) 이면
# dp식을 구할 때, 0번 선분을 넣고 (기울기 = b[0], 절편 = dp[0])
# 현재 들어간 선분 중 최솟값 찾기 (dp[1])
# 1번 선분을 집어넣고 (기울기 = b[1], 절편 = dp[1])
# 현재 들어간 선분 중 최솟값 찾기 (dp[2])
# dp를 계산하는데 O(n)이 걸린다고 하면 O(logn)으로 단축 가능

def gradient(a, b):
    return (a[1]-b[1])//(b[0]-a[0])

def add(p):
    while len(k) > 1 and gradient(k[-2], k[-1]) > gradient(k[-1], p):
        k.pop()
    k.append(p)

def search(p):
    left, right = 0, len(k)-1
    while left < right:
        mid = (left+right)//2
        if gradient(k[mid], k[mid+1]) <= p:
            left = mid+1
        else:
            right = mid
    return k[left][0]*p + k[left][1]


n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
dp = [0]*n

k = [[b[0], 0]]
for i in range(1, n):
    dp[i] = search(a[i])
    add([b[i], dp[i]])

print(dp[-1])
