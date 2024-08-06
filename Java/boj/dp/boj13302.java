package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13302 {
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
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Set<Integer> holidays = new HashSet<>();
        if(K != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++) holidays.add(Integer.parseInt(st.nextToken()));
        }

        int[][] dp = new int[110][110];
        for(int i=0; i<110; i++) Arrays.fill(dp[i], 987654321);
        dp[0][0] = 0;

        for(int i=0; i<N+1; i++) for(int j=0; j<40; j++) {
            if(dp[i][j] == 987654321) continue;

            int ret = dp[i][j];

            if(holidays.contains(i+1)) dp[i+1][j] = Math.min(dp[i+1][j], ret);

            if(j >= 3) dp[i+1][j-3] = Math.min(dp[i+1][j-3], ret);

            dp[i+1][j] = Math.min(dp[i+1][j], ret+10000);

            for(int k=1; k<4; k++) dp[i+k][j+1] = Math.min(dp[i+k][j+1], ret+25000);

            for(int k=1; k<6; k++) dp[i+k][j+2] = Math.min(dp[i+k][j+2], ret+37000);
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<110; i++) min = Math.min(min, dp[N][i]);

        bw.write(min+"");
    }

}
