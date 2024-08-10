package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj16432 {
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
        int n = Integer.parseInt(br.readLine());
        
        int[][] prev = new int[n+1][10];
        boolean[][] dp = new boolean[n+1][10];
        Arrays.fill(dp[0], true);

        for(int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j=0; j<m; j++) {
                int cur = Integer.parseInt(st.nextToken());
                for(int k=1; k<10; k++) {
                    if(cur == k) continue;
                    if(dp[i-1][k]) {
                        prev[i][cur] = k;
                        dp[i][cur] = true;
                        break;
                    }
                }
            }
        }

        for(int j=1; j<10; j++) {
            if(dp[n][j]) {
                sb = new StringBuilder();
                int cur = j;
                for(int i=n; i>0; i--) {
                    sb.append('\n').append(cur);
                    cur = prev[i][cur];
                }
                bw.write(sb.reverse().toString());
                return;
            }
        }

        bw.write("-1");
    }

}
