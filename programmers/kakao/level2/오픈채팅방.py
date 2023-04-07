from collections import defaultdict

def solution(record):
    tmp = []
    name = defaultdict(str)
    for i in range(len(record)):
        cmd = record[i].split()
        if len(cmd) == 3:
            state, ids, nick = cmd[0], cmd[1], cmd[2]
            name[ids] = nick
            if state == "Enter":
                tmp.append([state, ids])
        else:
            state, ids = cmd[0], cmd[1]
            tmp.append([state, ids])
    
    answer = []
    for t in tmp:
        if t[0] == "Enter":
            s = f"{name[t[1]]}님이 들어왔습니다."
        else:
            s = f"{name[t[1]]}님이 나갔습니다."
        answer.append(s)
    
    return answer


record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
print(solution(record)) # ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
