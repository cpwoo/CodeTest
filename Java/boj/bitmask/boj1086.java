package CodeTest.Java.boj.bitmask;

import java.io.*;
import java.math.*;

public class boj1086 {
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
        int n = Integer.parseInt(br.readLine());
        BigInteger[] s = new BigInteger[n];
        for(int i=0; i<n; i++) {
            s[i] = new BigInteger(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        int[][] r = new int[n][k];
        for (int i=0; i<n; i++) {
            BigInteger power = BigInteger.TEN.pow(s[i].toString().length());
            for (int j=0; j<k; j++) {
                r[i][j] = (BigInteger.valueOf(j).multiply(power).add(s[i])).mod(BigInteger.valueOf(k)).intValue();
            }
        }

        long[][] dp = new long[1<<n][k];
        dp[0][0] = 1;

        for(int b=0; b<(1<<n); b++) {
            for(int i=0; i<n; i++) {
                if((b&(1<<i)) != 0) continue;
                for(int j=0; j<k; j++) {
                    dp[b|(1<<i)][r[i][j]] += dp[b][j];
                }
            }
        }
        
        long x = dp[(1<<n)-1][0];
        long y = 0;
        for(int i=0; i<k; i++) {
            y += dp[(1<<n)-1][i];
        }

        long g = gcd(x, y);

        bw.write(x/g+"/"+y/g+"");
    }

    private static long gcd(long x, long y) {
        return (y == 0) ? x : gcd(y, x%y);
    }

}
