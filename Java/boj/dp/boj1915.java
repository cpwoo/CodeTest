package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1915 {
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
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            String inp = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = inp.charAt(j)-'0';
            }
        }

        int[][] dp = new int[n][m];
        int ret = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 || j == 0) dp[i][j] = arr[i][j];
                else if(arr[i][j] == 0) dp[i][j] = 0;
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;

                ret = Math.max(ret, dp[i][j]);
            }
        }

        bw.write(ret*ret+"");
    }

}
