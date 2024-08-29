package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2436 {
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
        int G = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int div = L/G;

        int a = 1, b = div;

        for(int i=1; i<div/2+1; i++) {
            if(div%i == 0) {
                int c = i, d = div/i;

                if(gcd(c, d) != 1) continue;

                if(a+b > c+d) {
                    a = c; b = d;
                }
            }
        }

        bw.write(a*G+" "+b*G+" ");
    }

    private static int gcd(int p, int q) {
        if(q == 0) return p;
        return gcd(q, p%q);
    }

}
