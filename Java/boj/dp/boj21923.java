package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj21923 {
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
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp1 = new long[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp1[i], -987654321);
        dp1[n-1][0] = arr[n-1][0];

        long[][] dp2 = new long[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp2[i], -987654321);
        dp2[n-1][m-1] = arr[n-1][m-1];

        for(int i=n-1; i>=0; i--) for(int j=0; j<m; j++) {
            if(i == n-1 && j == 0) continue;
            if(i < n-1) dp1[i][j] = Math.max(dp1[i][j], dp1[i+1][j]);
            if(j > 0) dp1[i][j] = Math.max(dp1[i][j], dp1[i][j-1]);
            dp1[i][j] += arr[i][j];
        }

        for(int i=n-1; i>=0; i--) for(int j=m-1; j>=0; j--) {
            if(i == n-1 && j == m-1) continue;
            if(i < n-1) dp2[i][j] = Math.max(dp2[i][j], dp2[i+1][j]);
            if(j < m-1) dp2[i][j] = Math.max(dp2[i][j], dp2[i][j+1]);
            dp2[i][j] += arr[i][j];
        }

        long max = -987654321;
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) {
            max = Math.max(max, dp1[i][j]+dp2[i][j]);
        }

        bw.write(max+"");
    }

}
