package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj11054 {
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

        int[][] matrix = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];

        for(int cnt=0; cnt<n-1; cnt++) for(int i=0; i<n-1-cnt; i++) {
            int j = i+cnt+1;
            dp[i][j] = Integer.MAX_VALUE;
            for(int k=i; k<j; k++) {
                dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+matrix[i][0]*matrix[k][1]*matrix[j][1]);
            }
        }

        bw.write(dp[0][n-1]+"");
    }

}
