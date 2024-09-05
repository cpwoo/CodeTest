package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj2211 {
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

    private static int dist[], parent[];
    private static List<int[]> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        dist = new int[n+1];
        Arrays.fill(dist, INF);

        parent = new int[n+1];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        dijkstra(1);

        sb = new StringBuilder();
        sb.append(n-1).append('\n');
        for(int i=2; i<n+1; i++) sb.append(i).append(' ').append(parent[i]).append('\n');

        bw.write(sb.toString());
    }

    private static void dijkstra(int start) {
        dist[start] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(dist[node.v] < node.w) continue;

            for(int[] nxt : graph[node.v]) {
                int nw = dist[node.v]+nxt[1];
                if(dist[nxt[0]] > nw) {
                    parent[nxt[0]] = node.v;
                    dist[nxt[0]] = nw;
                    q.add(new Node(nxt[0], nw));
                }
            }
        }
    }

}
