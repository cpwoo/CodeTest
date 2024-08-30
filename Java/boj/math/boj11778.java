package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj11778 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long g = gcd(n, m);
        
        long[][] mat = new long[][]{{1,1},{1,0}};

        bw.write(power(mat, g)[0][1]+"");
    }

    private static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    private static long[][] power(long[][] a, long n) {
        long[][] ret = new long[][]{{1,0},{0,1}};
        while(n != 0) {
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
