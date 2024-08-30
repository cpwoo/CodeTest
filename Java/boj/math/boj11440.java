package CodeTest.Java.boj.math;

import java.io.*;

public class boj11440 {
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

        long[][] a = power(mat, n);

        bw.write((a[0][0]*a[0][1])%mod+"");
    }

    private static long[][] power(long[][] a, long n) {
        long[][] ret = new long[][]{{1,0},{0,1}};
        while(n > 0) {
            if(n%2 == 1) ret = mul(ret, a);
            a = mul(a, a);
            n /= 2;
        }
        return ret;
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ret = new long[][]{{0,0},{0,0}};
        for(int i=0; i<2; i++) for(int j=0; j<2; j++) for(int k=0; k<2; k++) {
            ret[i][j] = (ret[i][j]+a[i][k]*b[k][j])%mod;
        }
        return ret;
    }

}
