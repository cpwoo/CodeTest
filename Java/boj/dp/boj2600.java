package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2600 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int b[], dp[][];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        b = new int[3];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++) b[i] = Integer.parseInt(st.nextToken());

        dp = new int[501][501];
        for(int i=0; i<501; i++) Arrays.fill(dp[i], -1);

        sb = new StringBuilder();
        for(int t=0; t<5; t++) {
            st = new StringTokenizer(br.readLine());
            int k1 = Integer.parseInt(st.nextToken());
            int k2 = Integer.parseInt(st.nextToken());
            sb.append((win(k1, k2) != 0) ? 'A' : 'B').append('\n');
        }

        bw.write(sb.toString());
    }

    private static int win(int p, int q) {
        if(dp[p][q] >= 0) return dp[p][q];

        for(int i=0; i<3; i++) {
            if(b[i] <= p && win(p-b[i], q) == 0) {
                return dp[p][q] = 1;
            }
        }

        for(int i=0; i<3; i++) {
            if(b[i] <= q && win(p, q-b[i]) == 0) {
                return dp[p][q] = 1;
            }
        }

        return dp[p][q] = 0;
    }

}
