package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj11562 {
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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(graph[i], 250);

        for(int i=1; i<n+1; i++) graph[i][i] = 0;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int state = Integer.parseInt(st.nextToken());
            graph[s][e] = 0; graph[e][s] = 1-state;
        }

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            if(graph[i][j] > graph[i][k]+graph[k][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
            }
        }

        sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(graph[s][e]).append('\n');
        }

        bw.write(sb.toString());
    }

}
