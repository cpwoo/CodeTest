package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj11758 {
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
        int[][] dot = new int[3][2];
        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(ccw(dot[0], dot[1], dot[2])+"");
    }

    private static int ccw(int[] p1, int[] p2, int[] p3) {
        long ret = (p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1])-(p1[1]*p2[0]+p2[1]*p3[0]+p3[1]*p1[0]);
        return Long.compare(ret, 0);
    }

}
