package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj13141 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] d = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) {
            Arrays.fill(d[i], INF);
            d[i][i] = 0;
        }

        int[][] a = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            d[s][e] = Math.min(d[s][e], l);
            d[e][s] = d[s][e];

            a[s][e] = Math.max(a[s][e], l);
            a[e][s] = a[s][e];
        }

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
        }

        double ret = Double.MAX_VALUE;
        for(int s=1; s<n+1; s++) {
            double cand = 0.0;
            for(int mid=1; mid<n+1; mid++) for(int e=1; e<n+1; e++) {
                if(d[mid][e] == INF) continue;

                double tmp = a[mid][e]-(d[s][e]-d[s][mid]);

                if(tmp > 0) cand = Math.max(cand, tmp/2+d[s][e]);
            }
            ret = Math.min(ret, cand);
        }

        bw.write(ret+"");
    }

}
