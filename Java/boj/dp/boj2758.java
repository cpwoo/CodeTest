package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2758 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long[][] dp = new long[11][2001];
        Arrays.fill(dp[0], 1);

        for(int i=1; i<11; i++) for(int j=1; j<2001; j++) {
            dp[i][j] = dp[i][j-1]+dp[i-1][j/2];
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(dp[n][m]).append('\n');
        }

        bw.write(sb.toString());
    }

}
