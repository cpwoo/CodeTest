import sys
input = lambda: sys.stdin.readline().rstrip()

def dfs(idx):
    if idx >= N:
        return 0
 
    if dp[idx] != -1:
        return dp[idx]
    max_value = 0
    for key in d.keys():
        score,len_string = d[key]
        if idx + len_string-1 < N:
            for check_idx in range(len_string):
                if S[check_idx+idx] != key[check_idx]:
                    break
            else:
                max_value = max(max_value, score+dfs(idx+len_string))
    max_value = max(max_value, 1+dfs(idx+1))
    dp[idx] = max_value
    return dp[idx]


S = input()
N = len(S)
M = int(input())
d = {}
for _ in range(M):
    string,score = input().split()
    d[string] = [int(score),len(string)]
 
dp = [-1]*(N+1)
print(dfs(0))
