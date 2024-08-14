package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj17386 {
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
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        long[] A = {x1, y1}, B = {x2, y2}, C = {x3, y3}, D = {x4, y4};

        bw.write((ccw(A,B,C)*ccw(A,B,D)<0 && ccw(C,D,A)*ccw(C,D,B)<0) ? "1" : "0");
    }

    private static int ccw(long[] u, long[] v, long[] w) {
        long ret = (u[0]*v[1]+v[0]*w[1]+w[0]*u[1])-(u[1]*v[0]+v[1]*w[0]+w[1]*u[0]);
        return Long.compare(ret, 0);
    }

}
