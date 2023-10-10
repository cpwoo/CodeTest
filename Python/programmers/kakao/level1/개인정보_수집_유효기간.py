def solution(today, terms, privacies):
    answer = []
    terms = {t[0]:int(t[2:]) for t in terms}
    for i, p in enumerate(privacies):
        date, kind = p.split()
        y, m, d = date.split(".")
        y = int(y) + (int(m)+terms[kind]-1)//12
        m = (int(m)+terms[kind]-1)%12 + 1
        date = ".".join([f"{y}", f"{m:02}", d])
        if today >= date:
            answer.append(i+1)

    return answer


today = "2022.05.19"
terms = ["A 6", "B 12", "C 3"]
privacies = ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
print(solution(today, terms, privacies)) # [1, 3]

today = "2020.01.01"
terms = ["Z 3", "D 5"]
privacies = ["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]
print(solution(today, terms, privacies)) # [1, 4, 5]
