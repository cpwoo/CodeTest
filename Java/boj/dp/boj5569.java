package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj5569 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int MOD = 100000;

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][][] dp = new int[w+1][h+1][2][2];

        for(int i=2; i<w+1; i++) dp[i][1][0][0] = 1;

        for(int i=2; i<h+1; i++) dp[1][i][1][0] = 1;

        for(int i=2; i<w+1; i++) for(int j=2; j<h+1; j++) {
            dp[i][j][0][0] = (dp[i-1][j][0][0]+dp[i-1][j][0][1])%MOD;
            dp[i][j][0][1] = dp[i-1][j][1][0];
            dp[i][j][1][0] = (dp[i][j-1][1][0]+dp[i][j-1][1][1])%MOD;
            dp[i][j][1][1] = dp[i][j-1][0][0];
        }
        
        int ret = 0;
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) {
            ret += dp[w][h][i][j];
        }

        bw.write(ret%MOD+"");
    }

}
