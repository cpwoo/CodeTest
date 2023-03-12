import sys
input = lambda: sys.stdin.readline().rstrip()

for _ in range(int(input())):
    K = int(input())
    arr = [0] + list(map(int, input().split()))

    # dp[i][j] = i번째부터 j번째까지 파일 합치는 최소값
    dp = [[0]*(K+1) for _ in range(K+1)]

    # 두 파일이 연속으로 되어있을 때의 합
    for i in range(1, K+1):
        for j in range(1, K+1):
            if j == i+1:
                dp[i][j] = arr[i] + arr[j]

    # dp[1][4] = dp[1][1] + dp[2][4] = dp[1][2] + dp[3][4] = dp[1][3] + dp[4][4]
    for i in range(K-1, 0, -1):
        for j in range(1, K+1):
            if dp[i][j] == 0 and j > i:
                dp[i][j] = min([dp[i][p]+dp[p+1][j] for p in range(i,j)]) + sum(arr[i:j+1])
    
    print(dp[1][K])
