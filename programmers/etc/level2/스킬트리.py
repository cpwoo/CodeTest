def solution(skill, skill_trees):
    answer = 0
    for s in skill_trees:
        tmp = ""
        for i in s:
            if i in skill:
                tmp += i
        if skill[:len(tmp)] == tmp:
            answer += 1
    return answer


skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees)) # 2
