package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj27718 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        long[][][] points = new long[n][2][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) for(int k=0; k<2; k++) {
                points[i][j][k] = Long.parseLong(st.nextToken());
            }
            if(compare(points[i][0], points[i][1]) > 0) {
                long[] tmp = points[i][0];
                points[i][0] = points[i][1];
                points[i][1] = tmp;
            }
        }

        int[][] ret = new int[n][n];
        for(int i=0; i<n; i++) {
            ret[i][i] = 3;
            for(int j=0; j<i; j++) {
                ret[i][j] = ret[j][i] = crossCheck(points[j][0], points[j][1], points[i][0], points[i][1]);
            }
        }

        sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(ret[i][j]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

    private static int crossCheck(long[] p1, long[] p2, long[] p3, long[] p4) {
        int abc = ccw(p1,p2,p3), abd = ccw(p1,p2,p4), cda = ccw(p3,p4,p1), cdb = ccw(p3,p4,p2);
        
        if(abc == 0 && abd == 0) {
            if(compare(p2, p3) < 0 || compare(p1, p4) > 0) return 0;
            if(compare(p2, p3) == 0 || compare(p1, p4) == 0) return 1;
            return 3;
        }

        if(abc == 0 || abd == 0) return cda == cdb ? 0 : 1;

        if(cda == 0 || cdb == 0) return abc == abd ? 0 : 1;

        if(abc+abd == 0 && cda+cdb == 0) return 2;

        return 0;
    }

    private static int ccw(long[] p1, long[] p2, long[] p3) {
        long res = (p1[0]*p2[1]+p2[0]*p3[1]+p3[0]*p1[1])-(p1[1]*p2[0]+p2[1]*p3[0]+p3[1]*p1[0]);
        return Long.compare(res, 0);
    }

    private static int compare(long[] a, long[] b) {
        if(a[0] != b[0]) return Long.compare(a[0], b[0]);
        return Long.compare(a[1], b[1]);
    }

}
