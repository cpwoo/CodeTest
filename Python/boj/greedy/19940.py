import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    x = int(input())
    ans = [0]*5
    
    ans[0] += x//60
    x %= 60

    d, m = x//10, x%10
    if x <= 35:
        if m > 5:
            ans[1] += d+1
            ans[4] += 10-m
        else:
            ans[1] += d
            ans[3] += m
    else:
        ans[0] += 1
        if m >= 5:
            ans[2] += 6-(d+1)
            ans[4] += 10-m
        else:
            ans[2] += 6-d
            ans[3] += m
    
    print(*ans)
