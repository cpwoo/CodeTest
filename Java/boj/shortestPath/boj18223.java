package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj18223 {
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

    private static int v;
    private static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        graph = new ArrayList[v+1];
        for(int i=0; i<v+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        bw.write((dijkstra(1, p)+dijkstra(p, v) <= dijkstra(1, v)) ? "SAVE HIM" : "GOOD BYE");
    }

    private static int dijkstra(int s, int e) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));

        int[] dist = new int[v+1];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int curNode = node.v, curCost = node.w;

            if(dist[curNode] < curCost) continue;

            for(Node nxt : graph[curNode]) {
                int nxtNode = nxt.v, nxtCost = nxt.w;
                int cost = curCost+nxtCost;

                if(dist[nxtNode] > cost) {
                    dist[nxtNode] = cost;
                    q.add(new Node(nxtNode, cost));
                }
            }
        }

        return dist[e];
    }

}
