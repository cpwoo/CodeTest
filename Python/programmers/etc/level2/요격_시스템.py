def solution(targets):
    targets.sort(key=lambda t: t[1])
    answer = 0
    prev_e = 0
    for s, e in targets:
        if s >= prev_e:
            prev_e = e
            answer += 1
    return answer


targets = [[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
print(solution(targets)) # 3
