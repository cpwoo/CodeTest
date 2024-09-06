package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj11657 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final long INF = Long.MAX_VALUE;
    
    private static int n;
    private static long d[];
    private static List<long[]> graph[];

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

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new long[]{b, c});
        }

        d = new long[n+1];
        Arrays.fill(d, INF);
        d[1] = 0;

        sb = new StringBuilder();

        if(!bellmanFord()) sb.append("-1");
        else {
            for(int i=2; i<n+1; i++) {
                sb.append((d[i] == INF) ? "-1" : d[i]).append('\n');
            }
        }

        bw.write(sb.toString());
    }

    private static boolean bellmanFord() {
        for(int t=0; t<n; t++) for(int i=1; i<n+1; i++) {
            for(long[] nxt : graph[i]) {
                if(d[i] != INF && d[(int)nxt[0]] > d[i]+nxt[1]) {
                    d[(int)nxt[0]] = d[i]+nxt[1];

                    if(t == n-1) return false;
                }
            }
        }
        return true;
    }

}
