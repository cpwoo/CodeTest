from heapq import *

def calc(time):
    h, m = map(int, time.split(":"))
    return h*60+m

def solution(book_time):
    q = []
    for s, e in book_time:
        s, e = calc(s), calc(e)
        heappush(q, [s, e])
    
    last = [-10]
    while q:
        cur_s, cur_e = heappop(q)
        if cur_s >= last[0]+10:
            heappop(last)
            heappush(last, cur_e)
        else:
            heappush(last, cur_e)
            
    return len(last)


book_time = [["15:00", "17:00"], ["16:40", "18:20"], ["14:20", "15:20"], ["14:10", "19:20"], ["18:20", "21:20"]]
print(solution(book_time)) # 3

book_time = [["09:10", "10:10"], ["10:20", "12:20"]]
print(solution(book_time)) # 1

book_time = [["10:20", "12:30"], ["10:20", "12:30"], ["10:20", "12:30"]]
print(solution(book_time)) # 3
