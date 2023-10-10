def solution(a):
    n = len(a)
    cnt = {}
    chk = {}
    for i in range(n):
        cnt[i] = 0
        chk[i] = -2
        
    for i in range(n-1):
        if a[i] != a[i+1]:
            if chk[a[i]] != i-1:
                cnt[a[i]] += 1
                chk[a[i]] = i
            if chk[a[i+1]] != i-1:
                cnt[a[i+1]] += 1
                chk[a[i+1]] = i

    return max(cnt.values())*2


a = [0]
print(solution(a)) # 0

a = [5,2,3,3,5,3]
print(solution(a)) # 4

a = [0,3,3,0,7,2,0,2,2,0]
print(solution(a)) # 8
