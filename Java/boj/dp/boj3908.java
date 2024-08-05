package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj3908 {
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
        boolean[] sieve = new boolean[1121];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;
        for(int i=2; i<1121; i++) {
            if(sieve[i]) {
                for(int j=i*i; j<1121; j+=i) {
                    sieve[j] = false;
                }
            }
        }

        List<Integer> prime = new ArrayList<>();
        for(int i=0; i<1121; i++) {
            if(sieve[i]) prime.add(i);
        }

        int[][] dp = new int[1121][15];
        dp[0][0] = 1;

        for(Integer p : prime) for(int i=1120; i>=p; i--) for(int j=1; j<15; j++) {
            dp[i][j] += dp[i-p][j-1];
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k]).append('\n');
        }
        
        bw.write(sb.toString());
    }

}
