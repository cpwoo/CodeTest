def solution(routes):
    answer = 0
    routes.sort(key=lambda t: t[1])
    end = -30001
    for s, e in routes:
        if end < s:
            end = e
            answer += 1
    return answer


routes = [[-20,-15], [-14,-5], [-18,-13], [-5,-3]]
print(solution(routes)) # 2
