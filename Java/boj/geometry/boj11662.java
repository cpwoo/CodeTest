package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj11662 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int ax, ay, bx, by, cx, cy, dx, dy;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        ax = Integer.parseInt(st.nextToken());
        ay = Integer.parseInt(st.nextToken());
        bx = Integer.parseInt(st.nextToken());
        by = Integer.parseInt(st.nextToken());
        cx = Integer.parseInt(st.nextToken());
        cy = Integer.parseInt(st.nextToken());
        dx = Integer.parseInt(st.nextToken());
        dy = Integer.parseInt(st.nextToken());

        bw.write(String.format("%.10f", ternarySearch(0.0, 1.0)));
    }

    private static double ternarySearch(double left, double right) {
        while(Math.abs(right-left) > 1e-9) {
            double left3 = (2*left+right)/3;
            double right3 = (left+2*right)/3;
            if(dist(left3) > dist(right3)) left = left3;
            else right = right3;
        }
        return dist(left);
    }

    private static double dist(double t) {
        double mx = ax*t + bx*(1-t);
        double my = ay*t + by*(1-t);
        double kx = cx*t + dx*(1-t);
        double ky = cy*t + dy*(1-t);
        return Math.sqrt((kx-mx)*(kx-mx)+(ky-my)*(ky-my));
    }

}
