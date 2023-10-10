import sys
input = lambda: sys.stdin.readline().rstrip()

# m+k-1 <= n <= m*k (각각 상황을 가정해보고 반드시 이 상황이 벌어져야 함을 증명할 것)
# 13, 5, 4 로 가정했을 때, [4,3,2,1],[6,5],[8,7],[10,9],[13,12,11]
# 9, 3, 3 로 가정했을 때, [3,2,1],[6,5,4],[9,8,7]
# 이런 식으로 수열을 생성하면 조건을 만족하는 수열 생성 가능

n, m, k = map(int, input().split())

if n < m+k-1 or n > m*k:
    print(-1)
else:
    l = list(range(k, 0, -1))
    n -= k
    m -= 1
    while m:
        l.extend(range(k+n//m, k, -1))
        k += n//m
        n -= n//m
        m -= 1
    print(*l)
