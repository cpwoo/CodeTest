package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj13430 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int mod = 1_000_000_007;
    private static int sz;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        sz = k+2;
        
        long[][] mat = new long[sz][sz];
        for(int i=0; i<sz; i++) for(int j=0; j<i+1; j++) mat[i][j] = 1;

        bw.write(power(mat, n)[sz-1][0]+"");
    }

    private static long[][] power(long[][] a, long n) {
        long[][] ret = new long[sz][sz];
        for(int i=0; i<sz; i++) ret[i][i] = 1;

        while(n != 0) {
            if(n%2 == 1) ret = mul(ret, a);
            a = mul(a, a);
            n /= 2;
        }

        return ret;
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] ret = new long[sz][sz];

        for(int i=0; i<sz; i++) for(int j=0; j<sz; j++) for(int k=0; k<sz; k++) {
            ret[i][j] = (ret[i][j]+a[i][k]*b[k][j])%mod;
        }
        
        return ret;
    }

}
