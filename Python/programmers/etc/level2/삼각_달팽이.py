def fill(y, x, sz):
    global m, cnt
    if sz <= 0:
        return
    if sz == 1:
        cnt += 1
        m[y][x] = cnt
        return
    for i in range(sz):
        cnt += 1
        m[y+i][x] = cnt
    for i in range(1, sz):
        cnt += 1
        m[y+sz-1][x+i] = cnt
    for i in range(1, sz-1):
        cnt += 1
        m[y+sz-i-1][x+sz-i-1] = cnt
    fill(y+2, x+1, sz-3)
    

def solution(n):
    global m, cnt
    answer = []
    m = [[0]*n for _ in range(n)]
    cnt = 0
    fill(0, 0, n)
    for i in range(n):
        for j in range(n):
            if m[i][j] != 0:
                answer.append(m[i][j])
    return answer


n = 4
print(solution(n)) # [1,2,9,3,10,8,4,5,6,7]

n = 5
print(solution(n)) # [1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]

n = 6
print(solution(n)) # [1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
