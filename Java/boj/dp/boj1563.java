package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1563 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int MOD = 1000000;
        int n = Integer.parseInt(br.readLine());   

        int[][][] dp = new int[n+1][2][3];
        dp[1][0][0] = dp[1][1][0] = dp[1][0][1] = 1;

        for(int i=2; i<n+1; i++) {
            dp[i][0][0] = (dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2])%MOD;
            dp[i][1][0] = (dp[i][0][0]+(dp[i-1][1][0]+dp[i-1][1][1]+dp[i-1][1][2]))%MOD;
            dp[i][0][1] = dp[i-1][0][0]%MOD;
            dp[i][0][2] = dp[i-1][0][1]%MOD;
            dp[i][1][1] = dp[i-1][1][0]%MOD;
            dp[i][1][2] = dp[i-1][1][1]%MOD;
        }

        int ret = 0;
        for(int i=0; i<2; i++) {
            for(int j=0; j<3; j++) {
                ret = (ret+dp[n][i][j])%MOD;
            }
        }

        bw.write(ret+"");
    }

}
