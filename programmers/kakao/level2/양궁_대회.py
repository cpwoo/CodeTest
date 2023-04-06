def solution(n, info):
    global answer, result

    def score(ryan):
        s = 0
        for i in range(11):
            if (ryan[i], info[i]) == (0, 0):
                continue
            if ryan[i] > info[i]:
                s += 10-i
            else:
                s -= 10-i
        return s

    def dfs(idx, left, ryan):
        global answer, result
        if idx == -1 and left:
            return
        if left == 0:
            s = score(ryan)
            if result < s:
                answer = ryan[:]
                result = s
            return
        for i in range(left, -1, -1):
            ryan[idx] = i
            dfs(idx-1, left-i, ryan)
            ryan[idx] = 0

    answer = [0]*11
    result = 0
    dfs(10, n, [0]*11)
    return answer if result != 0 else [-1]


n, info = 5, [2,1,1,1,0,0,0,0,0,0,0]
print(solution(n, info)) # [0,2,2,0,1,0,0,0,0,0,0]

n, info = 1, [1,0,0,0,0,0,0,0,0,0,0]
print(solution(n, info)) # [-1]

n, info = 9, [0,0,1,2,0,1,1,1,1,1,1]
print(solution(n, info)) # [1,1,2,0,1,2,2,0,0,0,0]

n, info = 10, [0,0,0,0,0,0,0,0,3,4,3]
print(solution(n, info)) # [1,1,1,1,1,1,1,1,0,0,2]
