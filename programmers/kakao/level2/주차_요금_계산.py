from math import ceil
from collections import defaultdict

def solution(fees, records):
    answer = []
    carNtime = defaultdict(list)
    for record in records:
        time, number, status = record.split()
        time = time.split(':')
        time = int(time[0])*60 + int(time[1])
        carNtime[number].append(time)
    
    for number in sorted(carNtime.keys()):
        if len(carNtime[number])&1:
            carNtime[number].append(1439)
        total = 0
        for i in range(len(carNtime[number])):
            if not i&1:
                total -= carNtime[number][i]
            else:
                total += carNtime[number][i]
        answer.append(total)
    
    for i in range(len(answer)):
        if answer[i] > fees[0]:
            answer[i] = fees[1] + ceil((answer[i]-fees[0])/fees[2]) * fees[3] 
        else:
            answer[i] = fees[1]
    
    return answer



fees = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
            "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
print(solution(fees, records)) # [14600, 34400, 5000]

fees = [120, 0, 60, 591]
records = ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]
print(solution(fees, records)) # [0, 591]

fees = [1, 461, 1, 10]
records = ["00:00 1234 IN"]
print(solution(fees, records)) # [14841]
