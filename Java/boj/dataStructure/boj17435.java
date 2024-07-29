package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj17435 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int log = 19;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[][] dp = new int[log][m+1];
        for(int i=1; i<m+1; i++) {
            dp[0][i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<log; i++) {
            for(int j=1; j<m+1; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }
        
        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int j=18; j>-1; j--) {
                if(n >= (1<<j)) {
                    n -= 1<<j;
                    x = dp[j][x];
                }
            }
            bw.write(x+"\n");
        }        
    }

}
