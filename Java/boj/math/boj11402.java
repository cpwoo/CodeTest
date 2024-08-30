package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj11402 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

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
        long k = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] fact = new long[m+1];
        fact[0] = fact[1] = 1;
        
        for(int i=2; i<m+1; i++) fact[i] = (fact[i-1]*i)%m;

        long ret = 1;
        
        while(n != 0 || k != 0) {
            int N = (int) (n%m);
            int K = (int) (k%m);

            if(N < K) {
                ret = 0;
                break;
            }

            ret = (ret*fact[N])%m;
            for(int i=0; i<m-2; i++) ret = ((ret*fact[K])%m*fact[N-K])%m;
            
            n /= m; k /= m;
        }

        bw.write(ret+"");
    }

}
