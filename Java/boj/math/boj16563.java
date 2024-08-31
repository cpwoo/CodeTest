package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj16563 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        final int max = 5_000_001;

        int[] sieve = new int[max];
        sieve[0] = sieve[1] = -1;
        for(int i=2; i<max; i++) sieve[i] = i;

        for(int i=2; i<(int)Math.sqrt(max)+1; i++) {
            if(sieve[i] == i) {
                for(int j=2*i; j<max; j+=i) {
                    if(sieve[j] == j) sieve[j] = i;
                }
            }
        }

        br.readLine();

        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int k = Integer.parseInt(st.nextToken());
            while(k > 1) {
                sb.append(sieve[k]).append(' ');
                k /= sieve[k];
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

}
