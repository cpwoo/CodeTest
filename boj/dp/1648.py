import sys
input = lambda: sys.stdin.readline().rstrip()

def solve(num, status):
    # 마지막 칸이 안 채워진 경우
    if num == n*m and status == 0: return 1
    
    # 마지막 칸을 넘어가는 경우
    if num >= n*m: return 0
    
    if dp[num][status] != -1: return dp[num][status]
    dp[num][status] = 0

    # 현재 칸이 채워진 경우 옆 칸으로 이동
    if status & 1: dp[num][status] = solve(num+1, status>>1)
    else:
        # 아니면 밑에 칸을 채우고 옆칸으로 이동
        dp[num][status] = solve(num+1, (status>>1)|1<<(m-1))
        # 행의 마지막 칸이 아니라면 옆칸을 채우고 옆옆칸으로 이동
        if num%m != m-1 and status & 2 == 0:
            dp[num][status] += solve(num+2, status>>2)
        
    dp[num][status] %= 9901
    return dp[num][status]


n, m = map(int, input().split())
dp = [[-1]*(1<<14) for _ in range(14**2)]
print(solve(0, 0))
