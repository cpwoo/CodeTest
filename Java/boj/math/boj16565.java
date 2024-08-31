package CodeTest.Java.boj.math;

import java.io.*;

public class boj16565 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int mod = 10007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int[][] comb = new int[53][53];
        for(int i=0; i<53; i++) {
            comb[i][0] = 1;
            for(int j=1; j<i+1; j++) {
                comb[i][j] = (comb[i-1][j-1]+comb[i-1][j])%mod;
            }
        }

        int n = Integer.parseInt(br.readLine());

        int ret = 0;
        for(int i=1, sign = 1; i<n/4+1; i++, sign *= -1) {
            ret += sign*(comb[13][i]*comb[52-4*i][n-4*i])%mod;
            ret = (ret+mod)%mod;
        }

        bw.write(ret+"");
    }

}
