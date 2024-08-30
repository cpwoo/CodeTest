package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj11439 {
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
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] sieve = new boolean[n+2];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        List<Integer> primes = new ArrayList<>();

        for(int i=2; i<n+1; i++) {
            if(sieve[i]) {
                primes.add(i);
                for(int j=2*i; j<n+1; j+=i) sieve[j] = false;
            }
        }

        int[] p = new int[primes.size()];

        for(int i=0; i<primes.size(); i++) {
            long j = primes.get(i);
            while(j <= n) {
                p[i] += (n/j)-(k/j)-((n-k)/j);
                j *= primes.get(i);
            }
        }

        long ret = 1;
        for(int i=0; i<primes.size(); i++) {
            for(int j=0; j<p[i]; j++) {
                ret *= primes.get(i);
                ret %= m;
            }
        }

        bw.write(ret+"");
    }

}
