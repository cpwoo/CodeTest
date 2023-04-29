def solution(name):
    answer = 0
    _min = len(name)-1
    for idx, s in enumerate(name):
        answer += min(ord(s)-ord("A"), ord("Z")-ord(s)+1)
        nxt = idx+1
        while nxt < len(name) and name[nxt] == "A":
            nxt += 1
        _min = min(_min, 2*idx+len(name)-nxt, idx+2*(len(name)-nxt))
    answer += _min
    return answer


name = "JEROEN"
print(solution(name)) # 56

name = "JAN"
print(solution(name)) # 23
