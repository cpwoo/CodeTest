from itertools import permutations

def solution(k, dungeons):
    answer = 0
    n = len(dungeons)
    for case in permutations(dungeons, n):
        tmp = k
        cnt = 0
        for c in case:
            if tmp < c[0]:
                continue
            tmp -= c[1]
            cnt += 1
        answer = max(answer, cnt)
        
    return answer


k = 80
dungeons = [[80,20],[50,40],[30,10]]
print(solution(k, dungeons)) # 3
