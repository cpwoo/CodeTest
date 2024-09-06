package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj14942 {
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

    private static List<Node> graph[];
    private static List<Integer> path[];
    private static int d[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            a--; b--;
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        path = new ArrayList[n];
        for(int i=0; i<n; i++) path[i] = new ArrayList<>();

        d = new int[n];
        Arrays.fill(d, INF);

        dijkstra(0);

        for(int i=1; i<n; i++) for(Node j : graph[i]) {
            if(j.v == path[i].get(0)) path[i].add(j.w);
        }
        path[0].add(0); path[0].add(0);

        sb = new StringBuilder();
        sb.append(1).append('\n');

        for(int i=1; i<n; i++) {
            int energy = arr[i], route = i;
            while(true) {
                energy -= path[route].get(1);
                if(energy < 0 || route == 0) {
                    sb.append(route+1).append('\n');
                    break;
                }
                route = path[route].get(0);
            }
        }

        bw.write(sb.toString());
    }

    private static void dijkstra(int v) {
        d[v] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(v, d[v]));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            if(d[cur.v] < cur.w) continue;

            for(Node nxt : graph[cur.v]) {
                int dist = cur.w+nxt.w;
                if(dist < d[nxt.v]) {
                    d[nxt.v] = dist;
                    path[nxt.v].add(cur.v);
                    q.add(new Node(nxt.v, dist));
                }
            }
        }
    }

}
