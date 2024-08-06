package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj12865 {
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

        int[][] items = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];

        for(int i=1; i<n+1; i++) {
            int weight = items[i-1][0], value = items[i-1][1];
            for(int j=1; j<k+1; j++) {
                if(weight <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        bw.write(dp[n][k]+"");
    }

}
