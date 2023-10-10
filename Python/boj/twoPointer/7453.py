import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = [list(map(int, input().rstrip().split())) for _ in range(n)]
ab, cd = [], []
for i in range(n):
    for j in range(n):
        ab.append(arr[i][0] + arr[j][1])
        cd.append(arr[i][2] + arr[j][3])
        
ab.sort(); cd.sort()

left, right = 0, len(cd)-1
result = 0
while left < len(ab) and right >= 0:
    if ab[left] + cd[right] == 0:
        nleft, nright = left+1, right-1
        while nleft < len(ab) and ab[left] == ab[nleft]:
            nleft += 1
        while nright >= 0 and cd[right] == cd[nright]:
            nright -= 1
        result += (nleft-left) * (right-nright)
        left, right = nleft, nright
    elif ab[left] + cd[right] > 0:
        right -= 1
    else:
        left += 1

print(result)
