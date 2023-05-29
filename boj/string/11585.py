import sys
input = lambda: sys.stdin.readline().rstrip()

def get_pi(keyword):
    K = len(keyword)
    pi = [0]*K

    j = 0
    for i in range(1, K):
        while keyword[i] != keyword[j] and j > 0:
            j = pi[j-1]
        
        if keyword[i] == keyword[j]:
            j += 1
            pi[i] = j
    
    return pi

def find(st, keyword):
    cnt = 0
    S, K = len(st), len(keyword)

    i, j = 0, 0
    while i < S:
        if st[i] == keyword[j]:
            i += 1; j += 1
        else:
            if j == 0:
                i += 1
            else:
                j = pi[j-1]
        
        if j == K:
            cnt += 1
            j = pi[j-1]
    
    return cnt


n = int(input())
target = list(input().split())
roulette = list(input().split())
roulette += roulette[:-1]

pi = get_pi(target)
cnt = find(roulette, target)

for i in range(cnt, 0, -1):
    if cnt%i == 0 and n%i == 0:
        print("{}/{}".format(cnt//i, n//i))
        break
