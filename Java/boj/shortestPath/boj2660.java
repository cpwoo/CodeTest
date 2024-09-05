package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj2660 {
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
        int n = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(graph[i], INF);

        while(true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(a == -1 && b == -1) break;

            graph[a][b] = graph[b][a] = 1;
        }

        for(int i=1; i<n+1; i++) graph[i][i] = 0;

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            if(graph[i][j] == 1 || graph[i][j] == 0) continue;

            else if(graph[i][j] > graph[i][k]+graph[k][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
            }
        }

        int[] r = new int[n];
        int min = INF;
        for(int i=1; i<n+1; i++) {
            int max = 0;
            for(int j=1; j<n+1; j++) max = Math.max(max, graph[i][j]);
            r[i-1] = max;
            min = Math.min(min, max);
        }

        int cnt = 0;
        for(int i=0; i<n; i++) if(r[i] == min) cnt++;

        sb = new StringBuilder();
        sb.append(min).append(' ').append(cnt).append('\n');

        for(int i=0; i<n; i++) {
            if(r[i] == min) sb.append(i+1).append(' ');
        }

        bw.write(sb.toString());
    }

}
