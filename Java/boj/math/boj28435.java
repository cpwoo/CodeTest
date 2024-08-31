package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj28435 {
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

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] c = new int[k];
        for (int a : arr) c[a%k]++;
        
        long ans = 1;

        for (int i=1; i<(k-1)/2+1; i++) {
            ans = ans*(modPow(2, c[i], mod)+modPow(2, c[k-i], mod)-1)%mod;
        }

        ans = ans*(c[0]+1)%mod;

        if (k%2 == 0) ans = ans*(c[k/2]+1)%mod;

        ans = (ans-(n+1)+mod)%mod;

        bw.write(ans+"");
    }

    private static long modPow(long base, int exp, int mod) {
        long ret = 1;

        while (exp > 0) {
            if (exp%2 == 1) ret = (ret*base)%mod;
            base = (base*base)%mod;
            exp /= 2;
        }

        return ret;
    }

}
