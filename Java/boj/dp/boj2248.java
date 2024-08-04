package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2248 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        long I = Long.parseLong(st.nextToken());

        int[][] dp = new int[N][L+1];
        for(int i=0; i<L+1; i++) dp[0][i] = 1;

        for(int i=1; i<N; i++) {
            dp[i][0] = dp[i-1][0];
            for(int j=1; j<L+1; j++) {
                dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
            }
        }

        sb = new StringBuilder();
        for(int i=N-1; i>=0; i--) {
            if(I <= dp[i][L]) sb.append('0');
            else {
                sb.append('1');
                I -= dp[i][L];
                L--;
            }
        }

        bw.write(sb.toString());
    }

}
