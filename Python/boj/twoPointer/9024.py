import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    n, k = map(int, input().split())
    arr = sorted(list(map(int, input().split())))

    _min = sys.maxsize
    cnt = 0
    left, right = 0, n-1

    while left < right:
        tmp = arr[left]+arr[right]

        if abs(k-tmp) < _min:
            _min = abs(k-tmp)
            cnt = 1
        elif abs(k-tmp) == _min:
            cnt += 1
        
        if k <= tmp: right -= 1
        else: left += 1
    
    print(cnt)
