package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1727 {
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

        int[] man = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++) man[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(man);

        int[] woman = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<m+1; i++) woman[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(woman);

        long[][] dp = new long[n+1][m+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++) {
                dp[i][j] = dp[i-1][j-1]+Math.abs(man[i]-woman[j]);
                if(i > j) dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                if(i < j) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
            }
        }

        bw.write(dp[n][m]+"");
    }

}
