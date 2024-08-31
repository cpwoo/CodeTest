package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj30806 {
    static class Comb {
        long[] fact, factInv;

        Comb(int sz) {
            fact = new long[sz+1];
            fact[0] = 1;
            for(int i=1; i<sz+1; i++) fact[i] = (fact[i-1]*i)%mod;

            factInv = new long[sz+1];
            factInv[sz] = modInverse(fact[sz], mod);
            for(int i=sz-1; i>=0; i--) factInv[i] = (factInv[i+1]*(i+1))%mod;
        }

        private static long modInverse(long a, int mod) {
            return pow(a, mod-2, mod);
        }

        private static long pow(long base, int exp, int mod) {
            long ret = 1;

            while(exp > 0) {
                if(exp%2 == 1) ret = (ret*base)%mod;
                base = (base*base)%mod;
                exp /= 2;
            }

            return ret;
        }

        long C(int n, int k) {
            if(k > n) return 0;
            return (((fact[n]*factInv[k])%mod)*factInv[n-k])%mod;
        }

    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int mod = 998244353;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> lst = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++) {
                lst.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(lst);

        int[] coeff = new int[n+1];

        int cnt = 0, last = -1;

        for(Integer i : lst) {
            if(i != last) {
                if(cnt > 0) coeff[cnt]++;
                cnt = 0; last = i;
            }
            cnt++;
        }

        coeff[cnt]++;

        Comb comb = new Comb(1000000);

        long[] ret = new long[n+1];
        for(int i=0; i<n+1; i++) {
            if(coeff[i] != 0) {
                for(int j=0; j<n+1; j++) {
                    ret[j] = (ret[j]+coeff[i]*comb.C(i,j))%mod;
                }
            }
        }

        sb = new StringBuilder();
        for(int i=1; i<n+1; i++) sb.append(ret[i]).append('\n');

        bw.write(sb.toString());
    }

}
