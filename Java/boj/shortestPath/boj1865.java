package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1865 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

    private static int n, dist[];
    private static List<int[]> graph[];

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

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        dist = new int[n+1];
        Arrays.fill(dist, INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, t});
            graph[e].add(new int[]{s, t});
        }

        for(int i=0; i<w; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e, -t});
        }

        sb.append(bellmanFord() ? "NO\n" : "YES\n");
    }

    private static boolean bellmanFord() {
        for(int i=1; i<n+1; i++) for(int j=1; j<n+1; j++) {
            for(int[] nxt : graph[j]) {
                if(dist[nxt[0]] > nxt[1]+dist[j]) {
                    dist[nxt[0]] = nxt[1]+dist[j];
                    
                    if(i == n) return false;
                }
            }
        }

        return true;
    }

}
