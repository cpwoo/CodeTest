package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj10835 {
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
        
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());

        int[] B = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) B[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][n+1];

        for(int i=n-1; i>=0; i--) for(int j=n-1; j>=0; j--) {
            if(B[j] < A[i]) dp[i][j] = Math.max(dp[i][j+1]+B[j], Math.max(dp[i+1][j], dp[i+1][j+1]));
            else dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]);
        }

        bw.write(dp[0][0]+"");
    }

}
