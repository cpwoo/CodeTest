def solution(cookie):
    n = len(cookie)
    answer = 0

    for i in range(n-1):
        leftSum, leftIdx = cookie[i], i
        rightSum, rightIdx = cookie[i+1], i+1

        while True:
            if leftSum == rightSum:
                answer = max(answer, leftSum)
            if leftIdx > 0 and leftSum <= rightSum:
                leftIdx -= 1
                leftSum += cookie[leftIdx]
            elif rightIdx < n-1 and rightSum <= leftSum:
                rightIdx += 1
                rightSum += cookie[rightIdx]
            else:
                break

    return answer


cookie = [1,1,2,3]
print(solution(cookie)) # 3

cookie = [1,2,4,5]
print(solution(cookie)) # 0
