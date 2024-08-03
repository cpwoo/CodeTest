package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2157 {
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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] path = new int[N+1][N+1];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            path[a][b] = Math.max(path[a][b], c);
        }

        int[][] dp = new int[N+1][M+1];

        for(int i=2; i<N+1; i++) dp[i][2] = path[1][i];

        for(int i=2; i<N+1; i++) {
            for(int j=3; j<M+1; j++) {
                for(int p=1; p<i; p++) {
                    if(path[p][i] != 0 && dp[p][j-1] != 0) {
                        dp[i][j] = Math.max(dp[i][j], dp[p][j-1]+path[p][i]);
                    }
                }
            }
        }

        int ret = 0;
        for(int i=0; i<M+1; i++) ret = Math.max(ret, dp[N][i]);

        bw.write(ret+"");
    }

}
