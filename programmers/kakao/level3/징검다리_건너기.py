def solution(stones, k):
    left, right = 1, int(2e8)
    while left <= right:
        tmp = stones[:]
        mid = (left+right)//2
        cnt = 0
        for t in tmp:
            if t - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break
        if cnt >= k:
            right = mid-1
        else:
            left = mid+1
    return left


stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k = 3
print(solution(stones, k)) # 3
