import sys
sys.setrecursionlimit(200000)

cost = [[1, 7, 6, 7, 5, 4, 5, 3, 2, 3], 
        [7, 1, 2, 4, 2, 3, 5, 4, 5, 6],
        [6, 2, 1, 2, 3, 2, 3, 5, 4, 5],
        [7, 4, 2, 1, 5, 3, 2, 6, 5, 4],
        [5, 2, 3, 5, 1, 2, 4, 2, 3, 5],
        [4, 3, 2, 3, 2, 1, 2, 3, 2, 3],
        [5, 5, 3, 2, 4, 2, 1, 5, 3, 2],
        [3, 4, 5, 6, 2, 3, 5, 1, 2, 4],
        [2, 5, 4, 5, 3, 2, 3, 2, 1, 2],
        [3, 6, 5, 4, 5, 3, 2, 4, 2, 1]]

dp = [[[-1]*10 for _ in range(10)] for _ in range(100001)]

def solve(numbers, N, idx, L, R):
    if (idx == N): return 0
    if (dp[idx][L][R] != -1): return dp[idx][L][R]

    num = int(numbers[idx])
    result = sys.maxsize

    if (num != R): result = min(result, solve(numbers,N,idx+1,num,R)+cost[L][num])
    if (num != L): result = min(result, solve(numbers,N,idx+1,L,num)+cost[R][num])

    dp[idx][L][R] = result

    return result

def solution(numbers):
    N = len(numbers)
    return solve(numbers, N, 0, 4, 6);


numbers = "1756"
print(solution(numbers)) # 10

numbers = "5123"
print(solution(numbers)) # 8
