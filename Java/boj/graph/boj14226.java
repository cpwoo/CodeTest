package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj14226 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(d[i], -1);
        d[1][0] = 0;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int s = cur[0], c = cur[1];

            if(d[s][s] == -1) {
                d[s][s] = d[s][c]+1;
                q.add(new int[]{s, s});
            }

            if(s+c <= n && d[s+c][c] == -1) {
                d[s+c][c] = d[s][c]+1;
                q.add(new int[]{s+c, c});
            }

            if(s-1 >= 0 && d[s-1][c] == -1) {
                d[s-1][c] = d[s][c]+1;
                q.add(new int[]{s-1, c});
            }
        }

        int ret = -1;
        for(int i=0; i<n+1; i++) {
            if(d[n][i] != -1) {
                if(ret == -1 || ret > d[n][i]) ret = d[n][i];
            }
        }

        bw.write(ret+"");
    }

}
