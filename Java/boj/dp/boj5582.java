package CodeTest.Java.boj.dp;

import java.io.*;

public class boj5582 {
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
        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length()+1][B.length()+1];

        int ret = 0;
        for(int i=1; i<A.length()+1; i++) for(int j=1; j<B.length()+1; j++) {
            if(A.charAt(i-1) == B.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1]+1;
                ret = Math.max(ret, dp[i][j]);
            }
        }

        bw.write(ret+"");
    }

}
