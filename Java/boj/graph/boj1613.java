package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1613 {
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
        int k = Integer.parseInt(st.nextToken());

        boolean[][] graph = new boolean[n][n];
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1][b-1] = true;
        }

        for(int p=0; p<n; p++) for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(i != j && !graph[i][j] && graph[i][p] && graph[p][j]) {
                graph[i][j] = true;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(graph[s-1][e-1]) sb.append("-1\n");
            else if(graph[e-1][s-1]) sb.append("1\n");
            else sb.append("0\n");
        }

        bw.write(sb.toString());
    }

}
