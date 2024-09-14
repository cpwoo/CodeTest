package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj10159 {
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[][] graph = new boolean[n][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a-1][b-1] = true;
        }

        for(int k=0; k<n; k++) for(int i=0; i<n; i++) for(int j=0; j<n; j++) {
            if(i != j && !graph[i][j] && graph[i][k] && graph[k][j]) {
                graph[i][j] = true;
            }
        }

        sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            int cnt = 0;
            for(int j=0; j<n; j++) {
                if(!graph[i][j] && !graph[j][i]) cnt++;
            }
            sb.append(cnt-1).append('\n');
        }

        bw.write(sb.toString());
    }

}
