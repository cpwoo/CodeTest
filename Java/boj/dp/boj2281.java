package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2281 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, name[];
    private static long max, dp[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        name = new int[n];
        for(int i=0; i<n; i++) name[i] = Integer.parseInt(br.readLine());
        
        max = m*m*n;
        dp = new long[n+1];
        Arrays.fill(dp, max);
        dp[n] = 0;

        bw.write(search(0)+"");
    }

    private static long search(int idx) {
        if(dp[idx] < max) return dp[idx];

        int remain = m-name[idx];
        for(int i=idx+1; i<n+1; i++) {
            if(remain >= 0) {
                if(i == n) {
                    dp[idx] = 0;
                    break;
                }
                dp[idx] = Math.min(dp[idx], remain*remain+search(i));
                remain -= name[i]+1;
            }
        }

        return dp[idx];
    }

}
