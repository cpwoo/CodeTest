import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, m, k = map(int, input().split())
    arr = list(map(int, input().split()))
    
    if n == m:
        if sum(arr) < k:
            print(1)
        else:
            print(0)
        continue

    cnt = 0
    money = sum(arr[:m])
    if money < k:
        cnt += 1

    for i in range(1, n):
        money += arr[(i+m-1)%n]-arr[i-1]
        if money < k:
            cnt += 1
    
    print(cnt)
