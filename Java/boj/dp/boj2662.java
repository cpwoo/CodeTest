package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2662 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int invest[][], path[];

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

        int[][] arr = new int[N+1][M+1];
        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j=1; j<M+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][M+1];
        invest = new int[N+1][M+1];

        for(int j=1; j<M+1; j++) for(int i=0; i<N+1; i++) for(int k=N-i; k>=0; k--) {
            if(dp[i+k][j] < dp[k][j-1]+arr[i][j]) {
                dp[i+k][j] = dp[k][j-1]+arr[i][j];
                invest[i+k][j] = i;
            }
        }

        path = new int[M+1];
        getPath(N, M);

        sb = new StringBuilder();

        sb.append(dp[N][M]).append('\n');
        for(int i=1; i<M+1; i++) sb.append(path[i]).append(' ');

        bw.write(sb.toString());
    }

    private static void getPath(int n, int m) {
        if(m == 0) return;
        path[m] = invest[n][m];
        getPath(n-path[m], m-1);
    }

}
