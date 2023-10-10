def solution(n, times):
    left, right = 0, max(times)*n
    while left+1 < right:
        mid = (left+right)//2
        tmp = 0
        for t in times:
            tmp += mid//t
        if tmp >= n:
            right = mid
        else:
            left = mid
    return right


n = 6
times = [7, 10]
print(solution(n, times)) # 28
