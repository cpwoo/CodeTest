package CodeTest.Java.boj.math;

import java.io.*;

public class boj2749 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int mod = 1_000_000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long n = Long.parseLong(br.readLine());
        
        int p = mod/10*15;
        int[] fibo = new int[p];
        fibo[1] = 1;
        for(int i=2; i<p; i++) {
            fibo[i] = (fibo[i-1]+fibo[i-2])%mod;
        }

        bw.write(fibo[(int)(n%p)]+"");
    }

}
