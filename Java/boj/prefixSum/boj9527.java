package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj9527 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static long[] psum;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String[] inp = br.readLine().split(" ");
        long a = Long.parseLong(inp[0]);
        long b = Long.parseLong(inp[1]);
        
        psum = new long[55];
        psum[0] = 1;
        for(int i=1; i<55; i++) {
            psum[i] = 2*psum[i-1]+(1L<<i);
        }
        
        bw.write(chk(b)-chk(a-1)+"");
    }

    private static long chk(long x) {
        long ans = x&1;
        for(int i=54; i>0; i--) {
            if((x&(1L<<i)) > 0L) {
                ans += psum[i-1]+(x-(1L<<i)+1);
                x -= (1L<<i);
            }
        }
        return ans;
    }

}
