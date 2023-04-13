def calc(time):
    h, m, s = map(int, time.split(":"))
    return h*3600 + m*60 + s

def solution(play_time, adv_time, logs):
    play_time, adv_time = calc(play_time), calc(adv_time)
    all_time = [0]*(play_time+1)
    for log in logs:
        start, end = log.split("-")
        start, end = calc(start), calc(end)
        all_time[start] += 1
        all_time[end] -= 1

    for i in range(1, len(all_time)):
        all_time[i] += all_time[i-1]

    for i in range(1, len(all_time)):
        all_time[i] += all_time[i-1]
    
    _max = all_time[adv_time-1]
    answer = 0
    for i in range(adv_time, play_time):
        tmp = all_time[i]-all_time[i-adv_time]
        if tmp > _max:
            _max = tmp
            answer = i-adv_time+1
    h = str(answer//3600).zfill(2)
    m = str(answer%3600//60).zfill(2)
    s = str(answer%3600%60).zfill(2)
    return ":".join([h, m, s])


play_time, adv_time = "02:03:55", "00:14:15"
logs = ["01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"]
print(solution(play_time, adv_time, logs)) # "01:30:59"

play_time, adv_time = "99:59:59", "25:00:00"
logs = ["69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"]
print(solution(play_time, adv_time, logs)) # "01:00:00"

play_time, adv_time = "50:00:00", "50:00:00"
logs = ["15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"]
print(solution(play_time, adv_time, logs)) # "00:00:00"
