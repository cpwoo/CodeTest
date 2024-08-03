package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj1633 {
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
        int[][] arr = new int[1001][2];
        int n = 0;
        String line;
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
            n++;
        }

        int[][][] dp = new int[n+1][16][16];

        for(int i=0; i<n; i++) {
            for(int w=0; w<16; w++) {
                for(int b=0; b<16; b++) {
                    if(w < 15) {
                        dp[i+1][w+1][b] = Math.max(dp[i+1][w+1][b], dp[i][w][b]+arr[i][0]);
                    }
                    if(b < 15) {
                        dp[i+1][w][b+1] = Math.max(dp[i+1][w][b+1], dp[i][w][b]+arr[i][1]);
                    }
                    dp[i+1][w][b] = Math.max(dp[i+1][w][b], dp[i][w][b]);
                }
            }
        }

        bw.write(dp[n][15][15]+"");
    }

}
