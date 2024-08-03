package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2208 {
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

        int[] jewel = new int[n];
        for(int i=0; i<n; i++) jewel[i] = Integer.parseInt(br.readLine());

        int[] sum = new int[n+1];
        for(int i=1; i<n+1; i++) sum[i] = sum[i-1]+jewel[i-1];

        int[] dp = new int[n+1];

        int chk = 0;
        for(int i=1; i<n+1; i++) {
            if(i >= m) {
                chk = Math.min(chk, sum[i-m]);
                dp[i] = Math.max(dp[i-1], sum[i]-chk);
            } else {
                dp[i] = dp[i-1];
            }
        }

        bw.write(dp[n]+"");
    }

}
