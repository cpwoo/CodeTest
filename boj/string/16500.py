import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(idx):
    global res
    if idx == len(s):
        res = 1
        return
    if dp[idx]: 
        return
    dp[idx] = 1
    for i in range(len(a)):
        if len(s[idx:]) >= len(a[i]):
            for j in range(len(a[i])):
                if a[i][j] != s[idx+j]:
                    break
            else:
                solve(idx+len(a[i]))
    return


s = input()
a = [input() for _ in range(int(input()))]
dp = [0]*101
res = 0
solve(0)

print(res)
