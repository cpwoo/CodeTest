package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj14786 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int a, b, c;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        double l = 0, r = 1_000_000;
        double x = (l+r)/2;

        while(Math.abs(r-l) >= 1e-9) {
            if(f(x) > 0) r = x;
            else l = x;
            x = (l+r)/2;
        }

        bw.write(x+"");
    }

    private static double f(double x) {
        return a*x+b*Math.sin(x)-c;
    }

}
