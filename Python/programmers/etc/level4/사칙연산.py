import sys

def solution(arr):
    INF = sys.maxsize
    
    num, op = [], []
    for a in arr:
        if a.isnumeric():
            num.append(int(a))
        else:
            op.append(a)
    
    n = len(num)
    MIN_DP = [[INF]*n for _ in range(n)]
    MAX_DP = [[-INF]*n for _ in range(n)]

    for step in range(n):
        for i in range(n-step):
            j = i+step
            if step == 0:
                MIN_DP[i][i] = num[i]
                MAX_DP[i][i] = num[i]
            else:
                for k in range(i, j):
                    if op[k] == "+":
                        MAX_DP[i][j] = max(MAX_DP[i][j], MAX_DP[i][k]+MAX_DP[k+1][j])
                        MIN_DP[i][j] = min(MIN_DP[i][j], MIN_DP[i][k]+MIN_DP[k+1][j])
                    else:
                        MAX_DP[i][j] = max(MAX_DP[i][j], MAX_DP[i][k]-MIN_DP[k+1][j])
                        MIN_DP[i][j] = min(MIN_DP[i][j], MIN_DP[i][k]-MAX_DP[k+1][j])

    return MAX_DP[0][n-1]


arr = ["1", "-", "3", "+", "5", "-", "8"]
print(solution(arr)) # 1

arr = ["5", "-", "3", "+", "1", "+", "2", "-", "4"]
print(solution(arr)) # 3
