def solution(e, starts):
    num = [0]*(e+1)
    for i in range(1, e+1):
        if i*i <= e:
            num[i*i] += 1
        for j in range(i+1, e+1):
            if i*j > e: break
            num[i*j] += 2
    
    freq = [0]*(e+1)
    freq[e] = e
    for i in range(e-1, min(starts)-1, -1):
        if num[freq[i+1]] <= num[i]:
            freq[i] = i
        else:
            freq[i] = freq[i+1]
            
    return [freq[s] for s in starts]


e, starts = 8, [1,3,7]
print(solution(e, starts)) # [6,6,8]
