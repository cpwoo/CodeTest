import sys
input = lambda: sys.stdin.readline().rstrip()

n, m = map(int, input().split())
arr = list(map(int, input().split()))

if n < m:
    print(n)
else:
    left, right = 0, (2_000_000_000 * 30)
    while left <= right:
        mid = (left+right)//2
        cnt = m
        for i in range(m):
            cnt += mid//arr[i]
        if cnt >= n: # n명을 태울 수 있으면
            t = mid
            right = mid-1
        else:
            left = mid+1
    # t-1 에 탑승한 사람 수 계산
    cnt = m
    for i in range(m):
        cnt += (t-1)//arr[i]
    # t 에 탑승한 사람 수 계산
    for i in range(m):
        if t%arr[i] == 0: # t 시간에 탑승한 사람
            cnt += 1
        if cnt == n:
            print(i+1)
            break
