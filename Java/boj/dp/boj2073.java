package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2073 {
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
        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] dp = new int[D+1];
        dp[0] = 1000000000;

        for(int i=0; i<P; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] tmp = Arrays.copyOf(dp, D+1);
            for(int j=L; j<D+1; j++) {
                if(tmp[j-L] != 0) {
                    dp[j] = Math.max(dp[j], Math.min(tmp[j-L], C));
                }
            }
        }

        bw.write(dp[D]+"");
    }

}
