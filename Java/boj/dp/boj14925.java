package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj14925 {
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
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[m+1][n+1];

        int max = 0;
        for(int i=1; i<m+1; i++) for(int j=1; j<n+1; j++) {
            if(arr[i-1][j-1] == 0) {
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write(max+"");
    }

}
