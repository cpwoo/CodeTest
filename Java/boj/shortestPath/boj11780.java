package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj11780 {
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

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];
        for(int i=0; i<n+1; i++) Arrays.fill(graph[i], INF);
        for(int i=0; i<n+1; i++) graph[i][i] = 0;

        int[][] path = new int[n+1][n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
            path[a][b] = b;
        }

        for(int k=1; k<n+1; k++) for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            if(graph[i][j] > graph[i][k]+graph[k][j]) {
                graph[i][j] = graph[i][k]+graph[k][j];
                path[i][j] = path[i][k];
            }
        }

        sb = new StringBuilder();

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                sb.append((graph[i][j] == INF) ? 0 : graph[i][j]).append(' ');
            }
            sb.append('\n');
        }

        List<Integer> ret = new ArrayList<>();

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(graph[i][j] == 0 || graph[i][j] == INF) {
                    sb.append("0\n");
                    continue;
                }
                int cur = i;
                while(cur != j) {
                    ret.add(cur);
                    cur = path[cur][j];
                }
                ret.add(j);
                sb.append(ret.size()).append(' ');
                for(int r : ret) sb.append(r).append(' ');
                sb.append('\n');

                ret.clear();
            }
        }

        bw.write(sb.toString());
    }

}
