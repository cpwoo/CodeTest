import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(idx, cnt):
    global answer
    
    if cnt == K-5:
        tmp = 0
        for word in words:
            check = True
            for w in word:
                if not learn[ord(w)-ord('a')]:
                    check = False
                    break
            if check:
                tmp += 1
        answer = max(answer, tmp)
        return
    
    for i in range(idx, 26):
        if not learn[i]:
            learn[i] = True
            dfs(i, cnt+1)
            learn[i] = False

N, K = map(int, input().split())

if K < 5:
    print(0)
    exit()    
elif K == 26:
    print(N)
    exit()
    
answer = 0
words = [set(input()) for _ in range(N)]
learn = [0] * 26

for c in ('a', 'c', 'i', 'n', 't'):
    learn[ord(c)-ord('a')] = 1
            
dfs(0, 0)
print(answer)
