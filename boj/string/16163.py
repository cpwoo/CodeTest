import sys
input = lambda: sys.stdin.readline().rstrip()

# 마나커 알고리즘 https://blog.naver.com/PostView.nhn?blogId=jqkt15&logNo=222108415284

def manacher(st):
    n = len(st)
    a = [0]*n
    c = 0
    r = 0
    answer = 0
    for now in range(n):
        if st[now] != "#":
            answer += 1
        
        if r < now:
            a[now] = 0
        else:
            a[now] = min(a[(2*c)-now], r-now)
            answer += a[now]//2
        
        while now-(a[now]+1) >= 0 and now+(a[now]+1) < n and st[now-(a[now]+1)] == st[now+(a[now]+1)]:
            a[now] += 1
            if st[now+a[now]] != "#":
                answer += 1
        
        if r < now+a[now]:
            r = now+a[now]
            c = now
    
    return answer


s = input()
print(manacher("#" + "#".join(s) + "#"))
