package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj17387 {
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

        bw.write(checkCross(A, B, C, D));
    }

    private static int ccw(long[] p1, long[] p2, long[] p3) {
        long ret = (p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1])-(p1[1]*p2[0]+p2[1]*p3[0]+p3[1]*p1[0]);
        return Long.compare(ret, 0);
    }

    private static char checkCross(long[] p1, long[] p2, long[] p3, long[] p4) {
        boolean flag = false;
        char ret = '0';

        int p123 = ccw(p1, p2, p3), p124 = ccw(p1, p2, p4), p341 = ccw(p3, p4, p1), p342 = ccw(p3, p4, p2);

        if(p123*p124 == 0 && p341*p342 == 0) {
            flag = true;
            if(Math.min(p1[0], p2[0]) <= Math.max(p3[0], p4[0]) && Math.min(p3[0], p4[0]) <= Math.max(p1[0], p2[0]) && Math.min(p1[1], p2[1]) <= Math.max(p3[1], p4[1]) && Math.min(p3[1], p4[1]) <= Math.max(p1[1], p2[1])) {
                ret = '1';
            }
        }

        if(p123*p124 <= 0 && p341*p342 <= 0 && !flag) ret = '1';

        return ret;
    }

}
