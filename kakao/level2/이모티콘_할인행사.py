from itertools import product

def solution(users, emoticons):
    answer = []
    
    e = len(emoticons)
    percent = list(product([10, 20, 30, 40], repeat=e))
    cases = []
    
    for p in percent:
        c = [[p[i], (100-p[i])*emoticons[i]//100] for i in range(e)]
        cases.append(c)

    for c in cases:
        arr = [0, 0]
        for u in users:
            tmp = 0
            for i in range(e):
                if u[0] <= c[i][0]:
                    tmp += c[i][1]
            if tmp < u[1]:
                arr[1] += tmp
            else:
                arr[0] += 1
        answer.append(arr)
    
    answer.sort(key=lambda t: (t[0], t[1]))

    return answer[-1]


users = [[40, 10000], [25, 10000]]
emoticons = [7000, 9000]
print(solution(users, emoticons)) # [1, 5400]

users = [[40, 2900], [23, 10000], [11, 5200], [5, 5900], [40, 3100], [27, 9200], [32, 6900]]
emoticons = [1300, 1500, 1600, 4900]
print(solution(users, emoticons)) # [4, 13860]
