package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj17396 {
    static class Node implements Comparable<Node> {
        int v; long w;
        Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {
            if(this.w != node.w) return Long.compare(this.w, node.w);
            return this.v-node.v;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static final long INF = 200_000_000_000L;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] fail = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) fail[i] = st.nextToken().equals("0");

        List<Node> graph[] = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        long[] d = new long[n];
        Arrays.fill(d, INF);
        d[0] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int curNode = node.v;
            long curCost = node.w;

            if(d[curNode] < curCost) continue;

            for(Node nxt : graph[curNode]) {
                int nxtNode = nxt.v;
                long nxtCost = nxt.w;
                long cost = curCost+nxtCost;

                if(d[nxtNode] > cost && (nxtNode == n-1 || fail[nxtNode])) {
                    d[nxtNode] = cost;
                    q.add(new Node(nxtNode, cost));
                }
            }
        }

        bw.write((d[n-1] != INF) ? d[n-1]+"" : "-1");
    }

}
