package CodeTest.Java.boj.math;

import java.io.*;

public class boj1344 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int[] prime = {2,3,5,7,11,13,17};
    private static final int[] combi = {153,816,8568,31824,31824,8568,18};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        double a = Double.parseDouble(br.readLine())/100;
        double b = Double.parseDouble(br.readLine())/100;

        double sa = 0, sb = 0;
        for(int i=0; i<7; i++) {
            sa += combi[i]*Math.pow(a, prime[i])*Math.pow(1.0-a, 18-prime[i]);
            sb += combi[i]*Math.pow(b, prime[i])*Math.pow(1.0-b, 18-prime[i]);
        }

        bw.write(sa+sb-sa*sb+"");
    }

}
