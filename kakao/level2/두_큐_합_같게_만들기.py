def solution(queue1, queue2):
    queue = queue1 + queue2
    tmp, total = sum(queue1), sum(queue)
    left, right = 0, len(queue1)
    cnt = 0
    while left <= right and right < len(queue):
        if tmp < total//2:
            tmp += queue[right]
            right += 1
            cnt += 1
        elif tmp > total//2:
            tmp -= queue[left]
            left += 1
            cnt += 1
        else:
            return cnt
    return -1

queue1, queue2 = [3, 2, 7, 2], [4, 6, 5, 1]
print(solution(queue1, queue2))

queue1, queue2 = [1, 2, 1, 2], [1, 10, 1, 2]
print(solution(queue1, queue2))

queue1, queue2 = [1, 1], [1, 5]
print(solution(queue1, queue2))
