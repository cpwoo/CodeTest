package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj10217 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

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
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]> graph[] = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, c, d});
        }

        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++) Arrays.fill(dp[i], INF);

        dp[1][0] = 0;

        for(int c=0; c<m+1; c++) for(int d=1; d<n+1; d++) {
            if(dp[d][c] == INF) continue;
            int t = dp[d][c];
            for(int[] nxt : graph[d]) {
                int nv = nxt[0], nc = nxt[1], nd = nxt[2];
                
                if(nc+c > m) continue;

                dp[nv][nc+c] = Math.min(dp[nv][nc+c], t+nd);
            }
        }

        int min = INF;
        for(int i=0; i<m+1; i++) min = Math.min(min, dp[n][i]);

        sb.append((min == INF) ? "Poor KCM" : min).append('\n');
    }

}
