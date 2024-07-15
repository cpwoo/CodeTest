package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj17425 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int max = 1000000;

        long[] dp = new long[max+1];
        long[] s = new long[max+1];

        for(int i=1; i<max+1; i++) {
            int j = 1;
            while(i*j <= max) {
                dp[i*j] += i;
                j++;
            }
            s[i] = s[i-1]+dp[i];
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            bw.write(s[Integer.parseInt(br.readLine())]+"\n");
        }
    }

}
