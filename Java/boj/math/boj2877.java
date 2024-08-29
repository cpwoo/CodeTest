package CodeTest.Java.boj.math;

import java.io.*;

public class boj2877 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int K = Integer.parseInt(br.readLine())+1;

        sb = new StringBuilder();
        while(K != 1) {
            if(K%2 == 1) sb.append('7');
            else sb.append('4');
            K /= 2;
        }

        bw.write(sb.reverse().toString());
    }

}
