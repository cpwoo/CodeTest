package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj17404 {
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

        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ret = 987654321;

        for(int i=0; i<3; i++) {
            int[][] dp = new int[n][3];
            for(int j=0; j<n; j++) Arrays.fill(dp[j], 987654321);
            dp[0][i] = arr[0][i];
            
            for(int j=1; j<n; j++) {
                dp[j][0] = arr[j][0]+Math.min(dp[j-1][1], dp[j-1][2]);
                dp[j][1] = arr[j][1]+Math.min(dp[j-1][0], dp[j-1][2]);
                dp[j][2] = arr[j][2]+Math.min(dp[j-1][0], dp[j-1][1]);
            }

            for(int j=0; j<3; j++) {
                if(i != j) ret = Math.min(ret, dp[n-1][j]);
            }
        }

        bw.write(ret+"");
    }

}
