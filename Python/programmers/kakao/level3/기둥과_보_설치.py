def check(ans):
    for x, y, a in ans:
        if a == 0:
            if y == 0 or [x-1, y, 1] in ans or [x, y, 1] in ans or [x, y-1, 0] in ans:
                continue
            return False
        else:
            if [x, y-1, 0] in ans or [x+1, y-1, 0] in ans or ([x-1, y, 1] in ans and [x+1, y, 1] in ans):
                continue
            return False
    return True

def solution(n, build_frame):
    answer = []
    for x, y, a, b in build_frame:
        if b:
            answer.append([x, y, a])
            if not check(answer): answer.remove([x, y, a])
        else:
            answer.remove([x, y, a])
            if not check(answer): answer.append([x, y, a])
    return sorted(answer)


n = 5
build_frame = [[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]
print(solution(n, build_frame)) # [[1,0,0],[1,1,1],[2,1,0],[2,2,1],[3,2,1],[4,2,1],[5,0,0],[5,1,0]]

n = 5
build_frame = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
print(solution(n, build_frame)) # [[0,0,0],[0,1,1],[1,1,1],[2,1,1],[3,1,1],[4,0,0]]
