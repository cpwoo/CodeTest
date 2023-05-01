def solution(weights):
    answer = 0
    cnt = [0]*1001
    for w in weights:
        cnt[w] += 1
    for i in range(100, 1001):
        answer += cnt[i]*(cnt[i]-1)//2
    for i in range(100, 667, 2):
        answer += cnt[i]*cnt[i*3//2]
    for i in range(102, 751, 3):
        answer += cnt[i]*cnt[i*4//3]
    for i in range(100, 501):
        answer += cnt[i]*cnt[i*2]
    return answer


weights = [100,180,360,100,270]
print(solution(weights)) # 4
