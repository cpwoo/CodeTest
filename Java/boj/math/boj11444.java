package CodeTest.Java.boj.math;

import java.io.*;

public class boj11444 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long n = Long.parseLong(br.readLine());
        
        long[][] mat = new long[][]{{1,1},{1,0}};

        bw.write(power(mat, n)[0][1]+"");
    }

    private static long[][] power(long[][] a, long n) {
        if(n == 1) {
            for(int x=0; x<2; x++) for(int y=0; y<2; y++) a[x][y] %= mod;
            return a;
        }
        long[][] tmp = power(a, n/2);
        return (n%2 == 0) ? mul(tmp, tmp) : mul(mul(tmp, tmp), a); 
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ret = new long[][]{{0,0},{0,0}};
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) for(int k=0; k<2; k++) {
            ret[i][j] = (ret[i][j]+a[i][k]*b[k][j])%mod;
        }
        return ret;
    }

}
