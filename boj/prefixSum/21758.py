import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
ans = 0
a = list(map(int, input().split()))
s = []
s.append(a[0])

# 누적 합
for i in range(1, n):
    s.append(s[i-1]+a[i])
    
# 꿀통이 왼쪽 끝
for i in range(1, n-1):
    ans = max(ans, s[n-2]+s[i-1]-a[i])

# 꿀통이 오른쪽 끝
for i in range(1, n-1):
    ans = max(ans, s[n-1]-a[0]+s[n-1]-s[i]-a[i])

# 꿀통이 가운데
for i in range(1, n-1):
    ans = max(ans, s[n-2]-a[0]+a[i])

print(ans)
