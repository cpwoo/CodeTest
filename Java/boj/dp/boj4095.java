package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj4095 {
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
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            int[][] arr = new int[n][m];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n][m];

            int ret = 0;
            for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
                if(i == 0 || j == 0) dp[i][j] = arr[i][j];
                else if(arr[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;

                ret = Math.max(ret, dp[i][j]);
            }

            sb.append(ret).append('\n');
        }

        bw.write(sb.toString());
    }

}
