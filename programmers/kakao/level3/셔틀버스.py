def solution(n, t, m, timetable):
    timetable = sorted([int(time[:2])*60+int(time[3:]) for time in timetable])

    busTime = [540+t*i for i in range(n)]

    i = 0
    for bt in busTime:
        cnt = 0
        while cnt < m and i < len(timetable) and timetable[i] <= bt:
            i += 1
            cnt += 1
        if cnt < m:
            answer = bt
        else:
            answer = timetable[i-1]-1

    return str(answer//60).zfill(2)+":"+str(answer%60).zfill(2)


n, t, m = 1, 1, 5
timetable = ["08:00", "08:01", "08:02", "08:03"]
print(solution(n, t, m, timetable)) # "09:00"

n, t, m = 2, 10, 2
timetable = ["09:10", "09:09", "08:00"]
print(solution(n, t, m, timetable)) # "09:09"

n, t, m = 2, 1, 2
timetable = ["09:00", "09:00", "09:00", "09:00"]
print(solution(n, t, m, timetable)) # "08:59"

n, t, m = 1, 1, 5
timetable = ["00:01", "00:01", "00:01", "00:01", "00:01"]
print(solution(n, t, m, timetable)) # "00:00"

n, t, m = 1, 1, 1
timetable = ["23:59"]
print(solution(n, t, m, timetable)) # "09:00"

n, t, m = 10, 60, 45
timetable = ["23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"]
print(solution(n, t, m, timetable)) # "18:00"
