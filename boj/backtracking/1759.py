import sys
input = lambda: sys.stdin.readline().rstrip()

L, C = map(int, input().split())
arr = sorted(list(input().split()))
consonant = ['a', 'e', 'i', 'o', 'u']
answer = []

def dfs(cnt, idx):
    if cnt == L:
        co, vo = 0, 0

        for i in range(L):
            if answer[i] in consonant:
                co += 1
            else:
                vo += 1
        
        if co >= 1 and vo >= 2:
            print(''.join(answer))
        return
    
    for i in range(idx, C):
        answer.append(arr[i])
        dfs(cnt+1, i+1)
        answer.pop()

dfs(0, 0)
