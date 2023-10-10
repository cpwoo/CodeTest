def solution(sticker):
    n = len(sticker)
    
    if n == 1: return sticker[0]
    
    # 첫 번째 뜯은 경우, 아닌 경우
    d1, d2 = [0]*n, [0]*n
    
    d1[0] = sticker[0]
    d1[1] = d1[0]
    for i in range(2, n-1):
        d1[i] = max(d1[i-2]+sticker[i], d1[i-1])
    
    for i in range(1, n):
        d2[i] = max(d2[i-2]+sticker[i], d2[i-1])
    
    return max(d1[-2], d2[-1])


sticker = [14, 6, 5, 11, 3, 9, 2, 10]
print(solution(sticker)) # 36

sticker = [1, 3, 2, 5, 4]
print(solution(sticker)) # 8
