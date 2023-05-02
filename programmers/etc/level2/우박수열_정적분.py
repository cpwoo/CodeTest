def solution(k, ranges):
    answer = []
    
    hail = []
    while k > 1:
        tmp = k
        if k&1:
            k = k*3+1
        else:
            k = k//2
        hail.append((tmp+k)/2)
    
    dp = [0]*(len(hail)+1)
    for i in range(1, len(hail)+1):
        dp[i] = dp[i-1] + hail[i-1]
    
    for a, b in ranges:
        b = len(dp)+b-1
        if a > b:
            answer.append(-1.0)
            continue
        answer.append(dp[b]-dp[a])
        
    return answer


k = 5
ranges = [[0,0],[0,-1],[2,-3],[3,-3]]
print(solution(k, ranges)) # [33.0,31.5,0.0,-1.0]
