package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2056 {
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
        int[] dp = new int[n+1];

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i], dp[num]+tmp);
            }
        }

        int ret = 0;
        for(int i=1; i<n+1; i++) ret = Math.max(ret, dp[i]);

        bw.write(ret+"");
    }

}
