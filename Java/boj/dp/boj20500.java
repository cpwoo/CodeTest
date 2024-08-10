package CodeTest.Java.boj.dp;

import java.io.*;

public class boj20500 {
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

        long[] dp = new long[1516];
        for(int i=2; i<1516; i++) {
            if(i%2 == 1) dp[i] = (2*dp[i-1]-1+mod)%mod;
            else dp[i] = (2*dp[i-1]+1)%mod;
        }

        bw.write(dp[Integer.parseInt(br.readLine())]+"");
    }

}
