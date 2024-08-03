package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1823 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int arr[], dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        dp = new int[n][n];
        bw.write(profit(0, n-1, 1)+"");
    }

    private static int profit(int start, int end, int cnt) {
        if(start == end) return cnt*arr[start];

        if(dp[start][end] != 0) return dp[start][end];

        return dp[start][end] = Math.max(
            profit(start+1, end, cnt+1)+cnt*arr[start],
            profit(start, end-1, cnt+1)+cnt*arr[end]);
    }

}
