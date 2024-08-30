package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj11401 {
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] fact = new long[n+1];
        fact[0] = fact[1] = 1;

        for(int i=2; i<n+1; i++) fact[i] = (fact[i-1]*i)%mod;

        long a = fact[n];
        long b = (fact[n-k]*fact[k])%mod;

        bw.write((a*power(b, mod-2))%mod+"");
    }

    private static long power(long base, int exp) {
        long ret = 1;

        while(exp > 0) {
            if(exp%2 == 1) ret = (ret*base)%mod;
            base = (base*base)%mod;
            exp /= 2;
        }
        
        return ret;
    }

}
