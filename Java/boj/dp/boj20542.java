package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj20542 {
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

        String w1 = br.readLine(), w2 = br.readLine();

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) dp[i][0] = i;
        for(int j=0; j<m+1; j++) dp[0][j] = j;

        for(int i=1; i<n+1; i++) for(int j=1; j<m+1; j++) {
            dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
            char a = w1.charAt(i-1), b = w2.charAt(j-1);
            if((a == b) || (a == 'v' && b == 'w') || (a == 'i' && (b == 'j' || b == 'l'))) {
                dp[i][j] = dp[i-1][j-1];
            }
        }

        bw.write(dp[n][m]+"");
    }

}
