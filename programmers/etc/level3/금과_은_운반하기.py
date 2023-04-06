def solution(a, b, g, s, w, t):
    answer = (10**9)*(10**5)*4
    start, end = 0, answer
    while start <= end:
        mid = (start+end)//2
        gold, silver, total = 0, 0, 0
        for i in range(len(t)):
            ng, ns, nw, nt = g[i], s[i], w[i], t[i]
            cnt = mid//(nt*2)
            if mid%(nt*2) >= nt:
                cnt += 1
            gold += ng if (ng < cnt*nw) else cnt*nw
            silver += ns if (ns < cnt*nw) else cnt*nw
            total += ng+ns if (ng+ns < cnt*nw) else cnt*nw
        if gold >= a and silver >= b and total >= a+b:
            end = mid-1
            answer = min(answer, mid)
        else:
            start = mid+1
    return answer


a, b, g, s, w, t = 10, 10, [100], [100], [7], [10]
print(solution(a, b, g, s, w, t)) # 50

a, b, g, s, w, t = 90, 500, [70,70,0], [0,0,500], [100,100,2], [4,8,1]
print(solution(a, b, g, s, w, t)) # 499
