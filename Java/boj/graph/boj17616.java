package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj17616 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int N, X;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Integer> parent[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) parent[i] = new ArrayList<>();

        List<Integer> child[] = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) child[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            parent[v].add(u);
            child[u].add(v);
        }

        bw.write((1+search(parent))+" "+(N-search(child))+"");
    }

    private static int search(List<Integer>[] graph) {        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(X);

        boolean[] visited = new boolean[N+1];
        visited[X] = true;

        int cnt = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph[cur]) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
