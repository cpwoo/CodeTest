import sys
input = lambda: sys.stdin.readline().rstrip()

N, M = map(int, input().split())
score = list(map(int, input().split()))

start, end = 0, max(score)
result = 0
while start <= end:
    mid = (start+end)//2
    _max = _min = score[0]
    cnt = 1
    for i in range(1, N):
        _max = max(_max, score[i])
        _min = min(_min, score[i])
        if _max - _min > mid:
            cnt += 1
            _max = score[i]
            _min = score[i]
    if cnt <= M:
        end = mid-1
        result = mid
    else:
        start = mid+1
        
print(result)
