package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj5719 {
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

    private static int s, d, graph[][], dist[];
    private static List<Integer> rGraph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            solve(n, m);
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve(int n, int m) throws Exception {
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(graph[i], INF);

        rGraph = new ArrayList[n];
        for(int i=0; i<n; i++) rGraph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph[u][v] = p;
            rGraph[v].add(u);
        }

        dist = new int[n];
        Arrays.fill(dist, INF);

        dijkstra(n);

        bfs();

        Arrays.fill(dist, INF);

        dijkstra(n);

        sb.append((dist[d] == INF) ? "-1" : dist[d]).append('\n');
    }

    private static void dijkstra(int n) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));
        dist[s] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            
            if(dist[node.v] < node.w) continue;

            for(int i=0; i<n; i++) {
                int cost = node.w+graph[node.v][i];
                if(cost < dist[i]) {
                    dist[i] = cost;
                    q.add(new Node(i, cost));
                }
            }
        }
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(d);
        while(!q.isEmpty()) {
            int v = q.poll();
            
            if(v == s) continue;

            for(Integer prev : rGraph[v]) {
                if(dist[prev]+graph[prev][v] == dist[v]) {
                    if(graph[prev][v] != INF) {
                        graph[prev][v] = INF;
                        q.add(prev);
                    }
                }
            }
        }
    }

}
