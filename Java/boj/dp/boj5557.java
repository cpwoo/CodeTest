package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj5557 {
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
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n][21];
        dp[0][arr[0]] = 1;

        for(int i=1; i<n-1; i++) for(int j=0; j<21; j++) {
            if(dp[i-1][j] != 0) {
                if(j+arr[i] <= 20) dp[i][j+arr[i]] += dp[i-1][j];
                if(j-arr[i] >= 0) dp[i][j-arr[i]] += dp[i-1][j];
            }
        }

        bw.write(dp[n-2][arr[n-1]]+"");
    }

}
