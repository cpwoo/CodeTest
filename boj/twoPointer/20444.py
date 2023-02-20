import sys
input = lambda: sys.stdin.readline().rstrip()

n, k = map(int, input().split())
left, right = 0, n//2
check = False

while left <= right:
    rowcut = (left+right)//2
    colcut = n - rowcut
    pieces = (rowcut+1) * (colcut+1)
    if k == pieces:
        print('YES')
        check = True
        break
    if k > pieces:
        left = rowcut+1
    else:
        right = rowcut-1

if not check:
    print('NO')
