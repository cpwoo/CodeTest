package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj1916 {
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

    private static final int INF = 1_000_000_000;

    private static int dist[];
    private static List<int[]> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        dist = new int[n+1];
        Arrays.fill(dist, INF);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(dist[end]+"");
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
                    dist[nxt[0]] = nw;
                    q.add(new Node(nxt[0], nw));
                }
            }
        }
    }

}
