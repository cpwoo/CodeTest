package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2673 {
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
        int[][] dp = new int[101][101];
        int[][] cost = new int[101][101];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cost[a][b] = cost[b][a] = 1;
        }

        for(int i=1; i<101; i++) for(int j=i; j>0; j--) for(int k=j; k<i; k++) {
            dp[j][i] = Math.max(dp[j][i], dp[j][k]+dp[k][i]+cost[i][j]);
        }

        bw.write(dp[1][100]+"");
    }

}
