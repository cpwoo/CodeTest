def solution(id_list, report, k):
    answer = [0]*len(id_list)
    result = {x:0 for x in id_list}

    for r in set(report):
        result[r.split()[1]] += 1
    
    for r in set(report):
        if result[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer


id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2
print(solution(id_list, report, k)) # [2,1,1,0]

id_list = ["con", "ryan"]
report = ["ryan con", "ryan con", "ryan con", "ryan con"]
k = 3
print(solution(id_list, report, k)) # [0, 0]
