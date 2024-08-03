package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2229 {
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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++) {
            int max = 0, min = 10001;
            for(int j=i; j>0; j--) {
                max = Math.max(max, arr[j-1]);
                min = Math.min(min, arr[j-1]);
                dp[i] = Math.max(dp[i], max-min+dp[j-1]);
            }
        }

        bw.write(dp[n]+"");
    }

}
