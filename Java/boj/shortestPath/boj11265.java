package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj11265 {
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
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int k=0; k<N; k++) for(int i=0; i<N; i++) for(int j=0; j<N; j++) {
            if(graph[i][j] > graph[i][k]+graph[k][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
            }
        }

        sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            sb.append((graph[A-1][B-1] <= C) ? "Enjoy other party\n" : "Stay here\n");
        }

        bw.write(sb.toString());
    }

}
