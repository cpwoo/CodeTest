import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
ans = 0
length = 1
cnt = 9

while k > length*cnt:
    k -= length*cnt
    ans += cnt
    length += 1
    cnt *= 10

ans = (ans+1)+((k-1)//length)

print(-1 if ans > n else str(ans)[(k-1)%length])
