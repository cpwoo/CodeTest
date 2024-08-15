package CodeTest.Java.boj.tree;

import java.io.*;
import java.util.*;

public class boj1240 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, graph[][], ret;
    private static boolean v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        ret = 0;

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = d;
        }

        sb = new StringBuilder();

        for(int i=0; i<m; i++) {
            v = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dfs(a, b, 0);
            sb.append(ret).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dfs(int s, int e, int dist) {
        v[s] = true;
        for(int i=1; i<n+1; i++) {
            if(graph[s][i] > 0 && !v[i]) {
                if(i == e) ret = dist+graph[s][i];
                else dfs(i, e, dist+graph[s][i]);
            }
        }
    }

}
