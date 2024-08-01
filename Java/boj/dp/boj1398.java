package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1398 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int[] coin = {1, 10, 25};
        
        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            long x = Long.parseLong(br.readLine());
            long ret = 0;
            long[] dp = new long[100];
            Arrays.fill(dp, 1_000_000_000_000_000L);
            dp[0] = 0;

            for(int c: coin) {
                for(int i=c; i<100; i++) {
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }

            while(x != 0) {
                ret += dp[Math.toIntExact(x%100)];
                x /= 100;
            }

            sb.append(ret).append('\n');
        }

        bw.write(sb.toString());
    }

}
