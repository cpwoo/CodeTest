package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj1069 {
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
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        double distance = Math.sqrt(x*x+y*y);

        int jump = (int) distance/d;

        double ret = 0;

        if(distance >= d) {
            ret = Math.min(t*jump+(distance-jump*d), Math.min(t*(jump+1), distance));
        }
        else {
            ret = Math.min(t+(d-distance), Math.min(2*t, distance));
        }

        bw.write(ret+"");
    }

}
