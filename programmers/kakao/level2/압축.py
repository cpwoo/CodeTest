def solution(msg):
    d = {"A":1, "B":2, "C":3, "D":4, "E":5, "F":6, "G":7,
        "H":8, "I":9, "J":10, "K":11, "L":12, "M":13, "N":14,
        "O":15, "P":16, "Q":17, "R":18, "S":19, "T":20, "U":21,
        "V":22, "W":23, "X":24, "Y":25, "Z":26}
    answer = []
    msg = list(msg)[::-1]
    tmp = ""
    cnt = 27
    while msg:
        p = msg.pop()
        if tmp+p in d.keys():
            tmp += p
        else:
            answer.append(d[tmp])
            msg.append(p)
            d[tmp+p] = cnt
            cnt += 1
            tmp = ""    
    answer.append(d[tmp])
    return answer


msg = "KAKAO"
print(solution(msg)) # [11, 1, 27, 15]

msg = "TOBEORNOTTOBEORTOBEORNOT"
print(solution(msg)) # [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]

msg = "ABABABABABABABAB"
print(solution(msg)) # [1, 2, 27, 29, 28, 31, 30]
