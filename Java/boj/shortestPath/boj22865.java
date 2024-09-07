package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj22865 {
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

    private static int n;
    private static List<Node> graph[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph[d].add(new Node(e, l));
            graph[e].add(new Node(d, l));
        }

        int[] a = dijkstra(A), b = dijkstra(B), c = dijkstra(C);

        int v = 0, ret = 0;
        for(int i=1; i<n+1; i++) {
            int now = Math.min(a[i], Math.min(b[i], c[i]));
            if(v < now) {
                v = now;
                ret = i;
            }
        }

        bw.write(ret+"");
    }

    private static int[] dijkstra(int s) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));

        int[] dist = new int[n+1];
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

        return dist;
    }

}
