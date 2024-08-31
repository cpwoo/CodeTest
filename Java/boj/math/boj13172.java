package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj13172 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int x = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long sum = 0;
        
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int g = gcd(n, s);
            n /= g; s /= g;

            sum += getExpectedValue(n, s);
            sum %= x;
        }

        bw.write(sum+"");
    }

    private static long getExpectedValue(int n, int s) {
        return (s*getSquredNumber(n, x-2))%x;
    }

    private static long getSquredNumber(int num, int exp) {
        if(exp == 1) return num;

        if(exp%2 == 0) {
            long half = getSquredNumber(num, exp/2);
            return (half*half)%x;
        }
        else return (num*getSquredNumber(num, exp-1))%x;
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }

}
