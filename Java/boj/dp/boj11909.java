package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj11909 {
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
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];

        for(int i=1; i<n; i++) {
            dp[i][0] = dp[i-1][0]+Math.max(arr[i][0]-arr[i-1][0]+1, 0);
            dp[0][i] = dp[0][i-1]+Math.max(arr[0][i]-arr[0][i-1]+1, 0);
        }

        for(int i=1; i<n; i++) for(int j=1; j<n; j++) {
            dp[i][j] = Math.min(dp[i-1][j]+Math.max(arr[i][j]-arr[i-1][j]+1, 0), dp[i][j-1]+Math.max(arr[i][j]-arr[i][j-1]+1, 0));
        }

        bw.write(dp[n-1][n-1]+"");
    }

}
