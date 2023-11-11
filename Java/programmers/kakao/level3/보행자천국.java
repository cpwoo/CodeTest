package CodeTest.Java.programmers.kakao.level3;

public class 보행자천국 {
    private static final int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m][n][2];
        
        for (int y=0; y<n; y++) {
            if (cityMap[0][y] == 1) break;
            dp[0][y][0] = 1;
        }

        for (int x=0; x<m; x++) {
            if (cityMap[x][0] == 1) break;
            dp[x][0][1] = 1;
        }

        for (int x=1; x<m; x++) {
            for (int y=1; y<n; y++) {
                if (cityMap[x][y] == 1) continue;

                dp[x][y][0] = dp[x][y-1][0];
                if (cityMap[x][y-1] == 0) {
                    dp[x][y][0] = (dp[x][y][0]+dp[x][y-1][1])%MOD;
                }

                dp[x][y][1] = dp[x-1][y][1];
                if (cityMap[x-1][y] == 0) {
                    dp[x][y][1] = (dp[x][y][1]+dp[x-1][y][0])%MOD;
                }
            }
        }

        return (dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
    }
}
