def solution(data, col, row_begin, row_end):
    answer = 0
    data.sort(key=lambda t: (t[col-1], -t[0]))
    for i in range(row_begin-1, row_end):
        tmp = 0
        for j in range(len(data[0])):
            tmp += data[i][j]%(i+1)
        answer ^= tmp
    return answer


data = [[2,2,6],[1,5,10],[4,2,9],[3,8,3]]
col, row_begin, row_end = 2, 2, 3
print(solution(data, col, row_begin, row_end)) # 4
