package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2240 {
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
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[T+1];
        for(int i=1; i<T+1; i++) arr[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[T+1][W+1];

        for(int i=1; i<T+1; i++) {
            if(arr[i] == 1) dp[i][0] = dp[i-1][0]+1;
            else dp[i][0] = dp[i-1][0];

            for(int j=1; j<W+1; j++) {
                if(j > i) break;

                if(arr[i] == 1 && j%2 == 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+1;
                }
                else if(arr[i] == 2 && j%2 == 1) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1])+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
                }
            }
        }

        int ret = 0;
        for(int i=0; i<W+1; i++) ret = Math.max(ret, dp[T][i]);

        bw.write(ret+"");
    }

}
