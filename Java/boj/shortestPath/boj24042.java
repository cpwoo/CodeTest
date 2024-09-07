package CodeTest.Java.boj.shortestPath;

import java.io.*;
import java.util.*;

public class boj24042 {
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

    private static final long INF = 200_000_000_000_000L;

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++) graph[i] = new ArrayList<>();

        for(int i=1; i<M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, i));
            graph[v].add(new Node(u, i));
        }

        long[] time = new long[N+1];
        Arrays.fill(time, INF);
        time[1] = 0;

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curNode = cur.v; long curCost = cur.w;

            if(time[curNode] < curCost) continue;

            for(Node nxt : graph[curNode]) {
                int nxtNode = nxt.v; long nxtCost = nxt.w;

                long cost = (curCost/M)*M+nxtCost;

                if(cost < curCost) cost += M;

                if(time[nxtNode] > cost) {
                    time[nxtNode] = cost;
                    q.add(new Node(nxtNode, cost));
                }
            }
        }

        bw.write(time[N]+"");
    }

}
