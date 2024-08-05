package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2698 {
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
        int[][][] dp = new int[101][100][2];
        dp[1][0][0] = 1; dp[1][0][1] = 1;

        for(int i=2; i<101; i++) for(int j=0; j<i; j++) {
            dp[i][j][0] = dp[i-1][j][0]+dp[i-1][j][1];
            dp[i][j][1] = dp[i-1][j][0]+((j>0) ? dp[i-1][j-1][1] : 0);
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k][0]+dp[n][k][1]).append('\n');
        }

        bw.write(sb.toString());
    }

}
