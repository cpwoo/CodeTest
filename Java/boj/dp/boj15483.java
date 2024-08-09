package CodeTest.Java.boj.dp;

import java.io.*;

public class boj15483 {
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
        String A = br.readLine(), B = br.readLine();
        int a = A.length(), b = B.length();

        int[][] dp = new int[a+1][b+1];

        for(int i=0; i<a+1; i++) dp[i][0] = i;

        for(int i=0; i<b+1; i++) dp[0][i] = i;

        for(int i=1; i<a+1; i++) for(int j=1; j<b+1; j++) {
            if(A.charAt(i-1) == B.charAt(j-1)) {
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
            }
        }

        bw.write(dp[a][b]+"");
    }

}
