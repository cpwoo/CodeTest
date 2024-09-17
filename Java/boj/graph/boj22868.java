package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj22868 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, m, s, e, route[], ret;
    private static List<Integer> adj[];
    private static boolean visited[];

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
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0; i<n+1; i++) Collections.sort(adj[i]);

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        route = new int[n+1];
        visited = new boolean[n+1];

        ret = 0;
        bfs(s, e);
        
        Arrays.fill(visited, false);
        int idx = route[e];
        while(idx != s) {
            visited[idx] = true;
            idx = route[idx];
        }

        bfs(e, s);
        
        bw.write(ret+"");
    }

    private static void bfs(int s, int e) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});
        visited[s] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0], cnt = cur[1];

            for(int nxt : adj[idx]) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    route[nxt] = idx;
                    q.add(new int[]{nxt, cnt+1});

                    if(nxt == e) {
                        ret += cnt+1;
                        return;
                    }
                }
            }
        }
    }

}
