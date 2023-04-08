def calc(time):
    h, m, s, ms = int(time[:2]), int(time[3:5]), int(time[6:8]), int(time[9:])
    return (h*3600+m*60+s)*1000+ms

def solution(lines):
    start_time, end_time = [], []
    for line in lines:
        line = line[11:]
        end, duration = line.split()
        end = calc(end)
        duration = int(float(duration[:-1])*1000)
        start = end-duration+1
        start_time.append(start)
        end_time.append(end)
    
    answer = 0
    for i in range(len(lines)):
        cnt = 0
        cur = end_time[i]
        for j in range(i, len(lines)):
            if cur > start_time[j]-1000:
                cnt += 1
        answer = max(answer, cnt)

    return answer


lines = ["2016-09-15 01:00:04.001 2.0s",
         "2016-09-15 01:00:07.000 2s"]
print(solution(lines)) # 1

lines = ["2016-09-15 01:00:04.002 2.0s",
         "2016-09-15 01:00:07.000 2s"]
print(solution(lines)) # 2

lines = ["2016-09-15 20:59:57.421 0.351s",
         "2016-09-15 20:59:58.233 1.181s",
         "2016-09-15 20:59:58.299 0.8s",
         "2016-09-15 20:59:58.688 1.041s",
         "2016-09-15 20:59:59.591 1.412s",
         "2016-09-15 21:00:00.464 1.466s",
         "2016-09-15 21:00:00.741 1.581s",
         "2016-09-15 21:00:00.748 2.31s",
         "2016-09-15 21:00:00.966 0.381s",
         "2016-09-15 21:00:02.066 2.62s"]
print(solution(lines)) # 7
