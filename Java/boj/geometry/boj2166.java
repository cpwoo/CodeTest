package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj2166 {
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
        int n = Integer.parseInt(br.readLine());
        
        long[] x = new long[n+1], y = new long[n+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[n] = x[0]; y[n] = y[0];

        long xr = 0, yr = 0;
        for(int i=0; i<n; i++) {
            xr += x[i]*y[i+1]; yr += y[i]*x[i+1];
        }

        bw.write(String.format("%.1f",Math.abs(xr-yr)/2D));
    }

}
