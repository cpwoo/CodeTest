def check(distance, rocks, mid):
    before, end = 0, distance
    
    cnt = 0
    for i in range(len(rocks)):
        if rocks[i]-before < mid:
            cnt += 1
            continue
        before = rocks[i]
    
    if end-before < mid: cnt += 1

    return cnt

def solution(distance, rocks, n):
    rocks.sort();

    answer = 0
    left, right = 1, distance
    while left <= right:
        mid = (left+right)//2
        if check(distance, rocks, mid) <= n:
            answer = mid
            left = mid+1
        else:
            right = mid-1
    
    return answer


distance, rocks, n = 25, [2, 14, 11, 21, 17], 2
print(solution(distance, rocks, n)) # 4
