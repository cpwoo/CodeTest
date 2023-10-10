def solution(keymap, targets):
    answer = []
    idx_dict = {}
    for key in keymap:
        for idx, k in enumerate(key):
            if k not in idx_dict or idx+1 < idx_dict[k]:
                idx_dict[k] = idx+1
                
    for target in targets:
        tmp = 0
        for idx, t in enumerate(target):
            if t not in idx_dict:
                answer.append(-1)
                break
            else:
                tmp += idx_dict[t]
                if idx == len(target)-1:
                    answer.append(tmp)
    
    return answer


keymap = ["ABACD","BCEFD"]
targets = ["ABCD","AABB"]
print(solution(keymap, targets)) # [9, 4]

keymap = ["AA"]
targets = ["B"]
print(solution(keymap, targets)) # [-1]

keymap = ["AGZ","BSSS"]
targets = ["ASA","BGZ"]
print(solution(keymap, targets)) # [4, 6]
