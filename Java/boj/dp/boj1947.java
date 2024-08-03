package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1947 {
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
        final int MOD = 1000000000;

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[0] = 1; dp[1] = 0;
        
        for(int i=2; i<n+1; i++) {
            dp[i] = (i-1)*(dp[i-1]+dp[i-2])%MOD;
        }

        bw.write(dp[n]+"");
    }

}
