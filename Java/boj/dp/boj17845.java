package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj17845 {
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

        int[][] dp = new int[k+1][n+1];
        
        for(int i=1; i<k+1; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            for(int j=1; j<n+1; j++) {
                if(time <= j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-time]+cost);
                else dp[i][j] = dp[i-1][j];
            }
        }

        bw.write(dp[k][n]+"");
    }

}
