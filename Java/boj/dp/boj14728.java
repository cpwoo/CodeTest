package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14728 {
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
        int k = Integer.parseInt(st.nextToken());

        int[][] subject = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) {
                subject[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<n+1; i++) {
            int time = subject[i-1][0], score = subject[i-1][1];
            for(int j=1; j<k+1; j++) {
                dp[i][j] = (time <= j) ? Math.max(dp[i-1][j], dp[i-1][j-time]+score) : dp[i-1][j];
            }
        }

        bw.write(dp[n][k]+"");
    }

}
