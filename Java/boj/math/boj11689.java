package CodeTest.Java.boj.math;

import java.io.*;

public class boj11689 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long n = Long.parseLong(br.readLine());
        double ret = n;
        for(int i=2; i<(int)Math.sqrt(n)+1; i++) {
            if(n%i == 0) {
                while(n%i == 0) n /= i;
                ret *= 1.0-(1.0/i);
            }
        }

        if(n > 1) ret *= 1.0-(1.0/n);

        bw.write((long)ret+"");
    }

}
