package CodeTest.Java.boj.geometry;

import java.io.*;
import java.util.*;

public class boj16958 {
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
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Set<Integer> special = new HashSet<>();
        int[][] pos = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            if(s == 1) special.add(i);
            pos[i][0] = Integer.parseInt(st.nextToken());
            pos[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dist = new int[N];
        Arrays.fill(dist, 1001);

        for(int i=0; i<N; i++) {
            int val = 1001;
            for(Integer s : special) {
                val = Math.min(val, distance(pos[i], pos[s]));
            }
            dist[i] = val;
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())-1;
            int q = Integer.parseInt(st.nextToken())-1;

            sb.append(Math.min(distance(pos[p], pos[q]), dist[p]+T+dist[q])).append('\n');
        }

        bw.write(sb.toString());
    }

    private static int distance(int[] u, int[] v) {
        return Math.abs(u[0]-v[0])+Math.abs(u[1]-v[1]);
    }

}
