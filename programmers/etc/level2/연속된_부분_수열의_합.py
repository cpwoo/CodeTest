def solution(sequence, k):
    answer = []
    n = len(sequence)
    tmp = sequence[0]
    left, right = 0, 0
    while left <= right:
        if tmp < k:
            right += 1
            if right == n:
                break
            tmp += sequence[right]
        elif tmp > k:
            tmp -= sequence[left]
            left += 1
        else:
            answer.append([right-left+1, left, right])
            tmp -= sequence[left]
            left += 1; right += 1
            if right == n:
                break
            tmp += sequence[right]
    answer.sort()
    return answer[0][1:]


sequence = [1, 2, 3, 4, 5]
k = 7
print(solution(sequence, k)) # [2,3]

sequence = [1, 1, 1, 2, 3, 4, 5]
k = 5
print(solution(sequence, k)) # [6,6]

sequence = [2, 2, 2, 2, 2]
k = 6
print(solution(sequence, k)) # [0,2]
