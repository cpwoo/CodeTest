package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj12781 {
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
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());        
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());        
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        int ans1 = ccw(x1, y1, x2, y2, x3, y3)*ccw(x1, y1, x2, y2, x4, y4);
        int ans2 = ccw(x3, y3, x4, y4, x1, y1)*ccw(x3, y3, x4, y4, x2, y2);

        bw.write((ans1 == -1 && ans2 == -1) ? '1' : '0');
    }

    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long ret = (x1*y2+x2*y3+x3*y1)-(y1*x2+y2*x3+y3*x1);
        return Long.compare(ret, 0);
    }

}
