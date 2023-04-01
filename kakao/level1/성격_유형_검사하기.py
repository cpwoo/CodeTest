from collections import defaultdict

def solution(survey, choices):
    answer = ""
    score = defaultdict(int)
    for i, j in zip(survey, choices):
        if j < 4:
            score[i[0]] += 4-j
        elif j > 4:
            score[i[1]] += j-4
        
    mbti = ["R","T","C","F","J","M","A","N"]
    for i in range(0, len(mbti), 2):
        if score[mbti[i]] >= score[mbti[i+1]]:
            answer += mbti[i]
        else:
            answer += mbti[i+1]
            
    return answer


survey = ["AN", "CF", "MJ", "RT", "NA"]
choices = [5, 3, 2, 7, 5]
print(solution(survey, choices)) # "TCMA"

survey = ["TR", "RT", "TR"]
choices = [7, 1, 3]
print(solution(survey, choices)) # "RCJA"
