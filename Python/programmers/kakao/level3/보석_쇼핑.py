def solution(gems):
    k = len(set(gems))
    d = {gems[0] : 1}
    answer = [1, len(gems)]
    start, end = 0, 0
    while start <= end and end < len(gems):
        if len(d) == k:
            if answer[1]-answer[0] > end-start:
                answer = [start+1, end+1]

            d[gems[start]] -= 1
            if d[gems[start]] == 0:
                del d[gems[start]]
            start += 1
        
        elif len(d) < k:
            end += 1
            if end >= len(gems):
                break

            if gems[end] not in d:
                d[gems[end]] = 1
            else:
                d[gems[end]] += 1
    
    return answer


gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
print(solution(gems)) # [3,7]

gems = ["AA", "AB", "AC", "AA", "AC"]
print(solution(gems)) # [1,3]

gems = ["XYZ", "XYZ", "XYZ"]
print(solution(gems)) # [1,1]

gems = ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]
print(solution(gems)) # [1,5]
