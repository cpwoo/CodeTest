package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13398 {
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

        int[][] dp = new int[n][2];

        dp[0][0] = arr[0];

        if(n > 1) {
            int ret = Integer.MIN_VALUE;
            for(int i=1; i<n; i++) {
                dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
                dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
                ret = Math.max(ret, Math.max(dp[i][0], dp[i][1]));
            }
            bw.write(ret+"");
        } else {
            bw.write(dp[0][0]+"");
        }
        
    }

}
