package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj17371 {
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
        
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        double max = Double.POSITIVE_INFINITY;
        int idx = 0;

        for(int i=0; i<n; i++) {
            double m = 0.0;
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                m = Math.max(m, dist(arr[i], arr[j]));
            }
            if(m < max) {
                max = m;
                idx = i;
            }
        }

        bw.write(arr[idx][0]+" "+arr[idx][1]+"");
    }

    private static double dist(int[] p1, int[] p2) {
        return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]));
    }

}
