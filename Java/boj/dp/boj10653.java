package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj10653 {
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

        int[][] points = new int[n+1][2];
        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        for(int i=2; i<n+1; i++) for(int j=0; j<k+1; j++) {
            if(dp[i][j] == 0) dp[i][j] = 987654321;

            for(int t=1; i-t>=1 && j-t+1>=0; t++) {
                int xLen = Math.abs(points[i][0]-points[i-t][0]);
                int yLen = Math.abs(points[i][1]-points[i-t][1]);
                dp[i][j] = Math.min(dp[i][j], dp[i-t][j-t+1]+xLen+yLen);
            }
        }

        bw.write(dp[n][k]+"");
    }

}
