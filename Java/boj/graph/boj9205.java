package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj9205 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        
        int[] home = new int[2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2; i++) home[i] = Integer.parseInt(st.nextToken());

        int[][] conv = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<2; j++) conv[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] fest = new int[2];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2; i++) fest[i] = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{home[0], home[1]});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(Math.abs(x-fest[0])+Math.abs(y-fest[1]) <= 1000) {
                sb.append("happy\n");
                return;
            }
            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    int nx = conv[i][0], ny = conv[i][1];
                    if(Math.abs(x-nx)+Math.abs(y-ny) <= 1000) {
                        q.add(new int[]{nx, ny});
                        visited[i] = true;
                    }
                }
            }
        }

        sb.append("sad\n");
    }

}
