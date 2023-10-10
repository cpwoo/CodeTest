from math import ceil

def solution(n, stations, w):
    answer = 0
    start = 1
    for station in stations:
        answer += max(ceil((station-w-start)/(2*w+1)), 0)
        start = station+w+1
    if n >= start:
        answer += ceil((n-start+1)/(2*w+1))
    return answer


n, station, w = 11, [4, 11], 1
print(solution(n, station, w)) # 3

n, station, w = 16, [9], 2
print(solution(n, station, w)) # 3
