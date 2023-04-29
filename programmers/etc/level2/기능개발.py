def solution(progresses, speeds):
    q = []
    for progress, speed in zip(progresses, speeds):
        if not q or q[-1][0] < -((progress-100)//speed):
            q.append([-((progress-100)//speed), 1])
        else:
            q[-1][1] += 1
    return [i[1] for i in q]


progresses = [93, 30, 55]
speeds = [1, 30, 5]
print(solution(progresses, speeds)) # [2, 1]

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]
print(solution(progresses, speeds)) # [1, 3, 2]
