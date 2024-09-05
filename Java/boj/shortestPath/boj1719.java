package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1719 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n+1][n+1];
        int[][] answer = new int[n+1][n+1];

        for(int i=0; i<n+1; i++) for(int j=0; j<n+1; j++) {
            if(i == j) {
                graph[i][j] = 0;
                answer[i][j] = INF;
            }
            else {
                graph[i][j] = INF;
                answer[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = d;
            answer[a][b] = b;
            answer[b][a] = a;
        }

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            if(graph[i][j] > graph[i][k]+graph[k][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
                answer[i][j] = answer[i][k];
            }
        }

        sb = new StringBuilder();

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                sb.append((answer[i][j] == INF) ? "-" : answer[i][j]).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
    }

}
