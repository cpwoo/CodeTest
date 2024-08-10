package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj18427 {
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
        int H = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dp = new int[H+2];
        dp[0] = 1;

        for(int i=0; i<N; i++) for(int j=H; j>=0; j--) for(int k=0; k<M; k++) {
            if(arr[i][k] != 0 && j-arr[i][k] >= 0) dp[j] = (dp[j]+dp[j-arr[i][k]])%10007;
        }

        bw.write(dp[H]+"");
    }

}
