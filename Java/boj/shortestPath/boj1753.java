package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1753 {
    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return this.w-node.w;
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static final int INF = 1_000_000_000;

    private static List<int[]> graph[];
    private static int dist[];
    private static Queue<Node> q;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v+1];
        for(int i=0; i<v+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, w});
        }

        dist = new int[v+1];
        Arrays.fill(dist, INF);

        q = new PriorityQueue<>();

        dijkstra(k);

        sb = new StringBuilder();
        for(int i=1; i<v+1; i++) {
            sb.append((dist[i] == INF) ? "INF" : dist[i]).append('\n');
        }

        bw.write(sb.toString());
    }

    private static void dijkstra(int start) {   
        dist[start] = 0;
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(dist[node.v] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                int nw = nxt[1]+node.w;
                
                if(dist[nxt[0]] > nw) {
                    dist[nxt[0]] = nw;
                    q.add(new Node(nxt[0], nw));
                }
            }
        }
    }

}
