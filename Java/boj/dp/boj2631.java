package CodeTest.Java.boj.dp;

import java.io.*;

public class boj2631 {
    private static BufferedReader br;
	private static BufferedWriter bw;

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
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j]) {
                    dp[i] = dp[j];
                }
            }
            dp[i]++;
        }

        int max = 0;
        for(int i=0; i<n; i++) max = Math.max(max, dp[i]);

        bw.write(n-max+"");
    }

}
