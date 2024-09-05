package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1956 {
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

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] graph = new int[v+1][v+1];
        for(int i=0; i<v+1; i++) Arrays.fill(graph[i], INF);

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = c;
        }

        for(int k=1; k<v+1; k++) for(int i=1; i<v+1; i++) for(int j=1; j<v+1; j++) {
            if(graph[i][k]+graph[k][j] < graph[i][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
            }
        }

        int ret = INF;
        for(int i=1; i<v+1; i++) ret = Math.min(ret, graph[i][i]);

        bw.write((ret != INF) ? ret+"" : "-1");
    }

}
