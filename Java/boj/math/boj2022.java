package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj2022 {
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
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0, right = Math.min(x, y);
        while(Math.abs(right-left) > 1e-6) {
            double mid = (left+right)/2;
            double h1 = Math.sqrt(x*x-mid*mid), h2 = Math.sqrt(y*y-mid*mid);
            double h = (h1*h2)/(h1+h2);

            if(h > c) left = mid;
            else right = mid;
        }

        bw.write(String.format("%.3f", left));
    }

}
