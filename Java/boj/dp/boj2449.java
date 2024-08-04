package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2449 {
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

        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        final int max = 987654321;

        int[][] dp = new int[n][n];
        for(int diff=1; diff<n; diff++) {
            for(int i=0; i<n-diff; i++) {
                dp[i][i+diff] = max;
                for(int mid=i; mid<i+diff; mid++) {
                    int tmp = (a[i] == a[mid+1]) ? 0 : 1;
                    dp[i][i+diff] = Math.min(dp[i][i+diff], dp[i][mid]+dp[mid+1][i+diff]+tmp);
                }
            }
        }

        bw.write(dp[0][n-1]+"");
    }

}
