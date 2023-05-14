def solution(sequence):
    sequence = [0]+[-1*val if idx%2 else val for idx, val in enumerate(sequence)]
    
    for i in range(len(sequence)-1):
        sequence[i+1] += sequence[i]
    
    return abs(max(sequence)-min(sequence))


sequence = [2, 3, -6, 1, 3, -1, 2, 4]
print(solution(sequence)) # 10
