package CodeTest.Java.boj.dp;

import java.io.*;

public class boj4811 {
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
        long[][] dp = new long[31][31];

        for(int i=1; i<31; i++) dp[0][i] = 1;

        for(int i=1; i<31; i++) for(int j=i; j<31; j++) {
            dp[i][j] += dp[i-1][j]+dp[i][j-1];
        }

        sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            sb.append(dp[n][n]).append('\n');
        }

        bw.write(sb.toString());
    }

}
