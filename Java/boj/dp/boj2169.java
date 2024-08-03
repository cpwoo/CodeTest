package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2169 {
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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j=1; j<m; j++) dp[0][j] += dp[0][j-1];

        for(int i=1; i<n; i++) {
            int[] leftToRight = Arrays.copyOf(dp[i], m);
            int[] rightToLeft = Arrays.copyOf(dp[i], m);

            for(int j=0; j<m; j++) {
                if(j == 0) leftToRight[j] += dp[i-1][j];
                else leftToRight[j] += Math.max(dp[i-1][j], leftToRight[j-1]);
            }

            for(int j=m-1; j>=0; j--) {
                if(j == m-1) rightToLeft[j] += dp[i-1][j];
                else rightToLeft[j] += Math.max(dp[i-1][j], rightToLeft[j+1]);
            }

            for(int j=0; j<m; j++) {
                dp[i][j] = Math.max(leftToRight[j], rightToLeft[j]);
            }
        }

        bw.write(dp[n-1][m-1]+"");
    }

}
