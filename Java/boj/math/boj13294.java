package CodeTest.Java.boj.math;

import java.io.*;

public class boj13294 {
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
        String n = br.readLine();
        double logN = n.length()-1+Math.log10(n.charAt(0)-'0');

        double s = 0;
        int i;
        for(i=1; i<10000000; i++) {
            s += Math.log10(i);
            if(s >= logN) break;
        }

        bw.write(i+"");
    }

}
