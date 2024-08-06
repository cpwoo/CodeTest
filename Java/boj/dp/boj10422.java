package CodeTest.Java.boj.dp;

import java.io.*;

public class boj10422 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int MOD = 1000000007;

        long[] dp = new long[5001];
        dp[0] = 1;
        for(int i=2; i<5001; i+=2) {
            for(int j=2; j<i+1; j+=2) {
                dp[i] = (dp[i]+dp[j-2]*dp[i-j])%MOD;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        bw.write(sb.toString());
    }

}
