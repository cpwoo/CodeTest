def solution(plans):
    plans = sorted(map(lambda x: [x[0], int(x[1][:2])*60+int(x[1][3:]), int(x[2])], plans), key=lambda x: -x[1])

    lst = []
    while plans:
        x = plans.pop()
        for i, v in enumerate(lst):
            if v[0] > x[1]:
                lst[i][0] += x[2]
        lst.append([x[1]+x[2], x[0]])
    lst.sort()

    return list(map(lambda x: x[1], lst))


plans = [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]
print(solution(plans)) # ["korean", "english", "math"]

plans = [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]
print(solution(plans)) # ["science", "history", "computer", "music"]

plans = [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]
print(solution(plans)) # ["bbb", "ccc", "aaa"]
