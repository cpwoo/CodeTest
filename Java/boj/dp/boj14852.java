package CodeTest.Java.boj.dp;

import java.io.*;

public class boj14852 {
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
        final int mod = 1_000_000_007;

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+2];
        dp[0] = 1; dp[1] = 2; dp[2] = 7;

        if(n <= 2) {
            bw.write(dp[n]+"");
            return;
        }

        for(int i=3; i<n+1; i++) dp[i] = (dp[i-1]*3+dp[i-2]-dp[i-3]+mod)%mod;

        bw.write(dp[n]+"");
    }

}
