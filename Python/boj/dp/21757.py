import sys
input = lambda: sys.stdin.readline().rstrip()

n = int(input())
arr = list(map(int, input().split()))

dp = [0]*n
dp[0] = arr[0]
for i in range(1, n):
    dp[i] = dp[i-1] + arr[i]

if dp[-1]%4 != 0:
    print(0)
elif dp[-1] == 0:
    tmp = dp.count(0)
    print((tmp-1)*(tmp-2)*(tmp-3)//6)
else:
    div = dp[-1]//4
    board = [[0 for _ in range(4)] for _ in range(n)]
    for i in range(1, n):
        if dp[i] == div:
            board[i][1] = board[i-1][1]
            board[i][2] = board[i-1][2]
            board[i][3] = board[i-2][3]
            
            board[i][0] = board[i-1][0]+1
            
        elif dp[i] == div*2:
            board[i][0] = board[i-1][0]
            board[i][2] = board[i-1][2]
            board[i][3] = board[i-2][3]
            
            board[i][1] = board[i-1][1] + board[i-1][0]
            
        elif dp[i] == div*3:
            board[i][0] = board[i-1][0]
            board[i][1] = board[i-1][1]
            board[i][3] = board[i-2][3]
            
            board[i][2] = board[i-1][2] + board[i-1][1]
            
        else:
            board[i] = board[i-1]
    print(board[n-1][2])
