def solution(name, yearning, photos):
    answer = []
    n = len(name)
    score = {}
    for i in range(n):
        score[name[i]] = yearning[i]
    for photo in photos:
        tmp = 0
        for p in photo:
            if p in score:
                tmp += score[p]
        answer.append(tmp)
    return answer


name = ["may", "kein", "kain", "radi"]
yearning = [5, 10, 1, 3]
photos = [["may", "kein", "kain", "radi"],["may", "kein", "brin", "deny"], ["kon", "kain", "may", "coni"]]
print(solution(name, yearning, photos)) # [19,5,6]

name = ["kali", "mari", "don"]
yearning = [11, 1, 55]
photos = [["kali", "mari", "don"], ["pony", "tom", "teddy"], ["con", "mona", "don"]]
print(solution(name, yearning, photos)) # [67,0,55]

name = ["may", "kein", "kain", "radi"]
yearning = [5, 10, 1, 3]
photo = [["may"],["kein", "deny", "may"], ["kon", "coni"]]
print(solution(name, yearning, photos)) # [5,15,0]
