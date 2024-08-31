package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj13977 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int N = 4_000_001;

        long[] fact = new long[N];
        fact[0] = fact[1] = 1;
        for(int i=2; i<N; i++) fact[i] = (fact[i-1]*i)%mod;

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            long A = fact[n];
            long B = (fact[k]*fact[n-k])%mod;

            long B2 = 1;
            int expo = mod-2;

            while(expo != 0) {
                if(expo%2 == 1) B2 = (B*B2)%mod;
                B = (B*B)%mod;
                expo /= 2;
            }

            sb.append((A*B2)%mod).append('\n');
        }

        bw.write(sb.toString());
    }

}
